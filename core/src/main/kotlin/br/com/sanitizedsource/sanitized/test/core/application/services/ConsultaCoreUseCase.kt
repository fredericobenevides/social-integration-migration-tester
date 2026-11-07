package br.com.sanitizedsource.sanitized.test.core.application.services

import br.com.sanitizedsource.sanitized.test.core.adapter.input.ResultadoResponse
import br.com.sanitizedsource.sanitized.test.core.application.port.input.ConsultaCorePortInput
import br.com.sanitizedsource.sanitized.test.core.application.port.output.ConsultaCorePortOutput
import br.com.sanitizedsource.sanitized.test.core.application.port.output.ServicoPortOutput
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ConsultaCoreUseCase(
        @Autowired private val consultaCore: ConsultaCorePortOutput,
        @Autowired private val servicoPortOutput: ServicoPortOutput,
        @Value("\${migration-tester.facebook.default-page-access-token:}") private val defaultFacebookPageAccessToken: String,
        @Value("\${migration-tester.facebook.ads-page-access-token:}") private val facebookAdsPageAccessToken: String,
        @Value("\${migration-tester.facebook.tagged-page-access-token:}") private val facebookTaggedPageAccessToken: String,
        @Value("\${migration-tester.facebook.ads-account-id:}") private val facebookAdsAccountId: String,
        @Value("\${migration-tester.instagram.access-token:}") private val instagramAccessToken: String,
        @Value("\${migration-tester.instagram.user-id:}") private val instagramUserId: String,
        @Value("\${migration-tester.instagram.tag:}") private val instagramTag: String,
        @Value("\${migration-tester.google-my-business.refresh-token:}") private val googleMyBusinessRefreshToken: String,
        @Value("\${migration-tester.google-my-business.location-id:}") private val googleMyBusinessLocationId: String) : ConsultaCorePortInput {

    override fun compararDadosDoCore(idServico: Long): String {
        val modelMapper = ModelMapper()

        val servico : Servico = servicoPortOutput.findById(idServico)

        val request = modelMapper.map(servico, ConsultaCorePortOutput.CoreRequest::class.java)
        carregaDadosNoRequestConformeServico(request)

        val resultadoCoreAntigo : ResultadoResponse = consultaCore.buscar(urlServer = "http://localhost:8010/core_antigo/busca", request = request)
        val resultadoCoreNovo : ResultadoResponse = consultaCore.buscar(urlServer = "http://localhost:8020/core_novo/busca", request = request)

        return validarDados(resultadoCoreAntigo, resultadoCoreNovo)
    }

    private fun validarDados(resultadoCoreAntigo : ResultadoResponse, resultadoCoreNovo : ResultadoResponse) : String {
        var response : String = ""
        var existeErro : Boolean = false

        response += "=>>>> SINCE ID - Core antigo: ${resultadoCoreAntigo.sinceID}; Core novo: ${resultadoCoreNovo.sinceID}\n"
        if (resultadoCoreAntigo.sinceID != resultadoCoreNovo.sinceID) {
            existeErro = true
        }

        val resultadoBuscaAntigo = resultadoCoreAntigo.resultadoBuscaResponse
        val resultadoBuscaNovo = resultadoCoreNovo.resultadoBuscaResponse

        response += "=>>>> TAMANHO - Core antigo: ${resultadoBuscaAntigo.size}; Core novo: ${resultadoBuscaNovo.size}\n"
        if (resultadoBuscaAntigo.size != resultadoBuscaNovo.size) {
            existeErro = true
        }

        var quantidadeAntigosFiltradas : Int = 0
        resultadoBuscaAntigo.filter { !it.filtrada }.forEach { quantidadeAntigosFiltradas += 1 }

        var quantidadeNovoFiltradas : Int = 0
        resultadoBuscaNovo.filter { !it.filtrada }.forEach { quantidadeNovoFiltradas += 1 }

        response += "=>>>> Filtradas - Core antigo: ${quantidadeAntigosFiltradas}; Core novo: ${quantidadeNovoFiltradas}\n"
        if (quantidadeAntigosFiltradas != quantidadeNovoFiltradas) {
            existeErro = true
        }

        var totalNaoLocalizados = 0
        for (rba in resultadoBuscaAntigo) {
            var existeResultado = false

            for (rbn in resultadoBuscaNovo) {
                if (rba.id == rbn.id) {
                    existeResultado = true
                    break
                }

            }

            if (!existeResultado) {
                existeErro = true
                response += "=>>>> Não localizado - Core antigo: ${rba.id}"

                totalNaoLocalizados += 1
            }
        }

        if (totalNaoLocalizados > 0) {
            response += "=>>>> Total não localizados: ${totalNaoLocalizados}"
        }

        println(response)

        if (existeErro) {
            response += "ERRO"
        }

        return response
    }

    private fun carregaDadosNoRequestConformeServico(request: ConsultaCorePortOutput.CoreRequest) {
        if (request.tipoServico == "facebook_tagged") {
            request.pageAccessToken = facebookTaggedPageAccessToken
        } else if (request.tipoServico == "facebook_anuncios") {
            request.pageAccessToken = facebookAdsPageAccessToken
            request.usuarioId = facebookAdsAccountId
        } else if (request.tipoServico.contains("facebook")) {
            request.pageAccessToken = defaultFacebookPageAccessToken
        } else if (request.tipoServico == "instagram_business_hashtags") {
            request.accessToken = instagramAccessToken
            request.usuarioId = instagramUserId
            request.tag = instagramTag
        } else if (request.tipoServico.contains("instagram")) {
            request.accessToken = instagramAccessToken
            request.usuarioId = instagramUserId
        } else if (request.tipoServico.contains("google_my_business")) {
            request.refreshToken = googleMyBusinessRefreshToken
            request.usuarioId = googleMyBusinessLocationId
        }
    }

}
