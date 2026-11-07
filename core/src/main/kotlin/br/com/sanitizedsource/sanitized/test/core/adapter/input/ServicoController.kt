package br.com.sanitizedsource.sanitized.test.core.adapter.input

import br.com.sanitizedsource.sanitized.test.core.application.port.input.ConsultaCorePortInput
import br.com.sanitizedsource.sanitized.test.core.application.port.input.ServicoPortInput
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("core")
class ServicoController(@Autowired val servicoPortInput: ServicoPortInput, @Autowired private val consultaCore: ConsultaCorePortInput)  {

    @GetMapping("listar")
    fun listar(): ResponseEntity<ServicoResponse> {
        val listaServicos = servicoPortInput.listar()

        val modelMapper = ModelMapper()

        val response = ServicoResponse()
        response.data = mutableListOf()

        for (servico in listaServicos) {
            val dataServico = modelMapper.map(servico, DataServico::class.java)
            response.data.add(dataServico)
        }

        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("salvar")
    fun salvar(@RequestBody request : ServicoRequest) : ResponseEntity<ServicoResponse> {
        val modelMapper = ModelMapper()

        val servico = modelMapper.map(request, Servico::class.java)
        val servicoSalvado = servicoPortInput.salvar(servico)

        val dataServico = modelMapper.map(servicoSalvado, DataServico::class.java)

        val servicoResponse = ServicoResponse()
        servicoResponse.msg = "Salvo com sucesso"
        servicoResponse.data.add(dataServico)

        return ResponseEntity(servicoResponse, HttpStatus.OK)
    }

    @PostMapping("atualizar")
    fun atualizar(@RequestBody request : ServicoRequest) : ResponseEntity<ServicoResponse> {
        val modelMapper = ModelMapper()

        val servico = modelMapper.map(request, Servico::class.java)
        val servicoAtualizado = servicoPortInput.atualizar(servico)

        val dataServico = modelMapper.map(servicoAtualizado, DataServico::class.java)
        val servicoResponse = ServicoResponse()
        servicoResponse.msg = "Atualizado com sucesso"
        servicoResponse.data.add(dataServico)

        return ResponseEntity(servicoResponse, HttpStatus.OK)
    }

    @DeleteMapping("remover/{id}")
    fun remover(@PathVariable("id") idServico: String) {
        servicoPortInput.remover(idServico.toLong())
    }

    @GetMapping("validar/{id}")
    fun validar(@PathVariable("id") idServico: String): ResponseEntity<String> {
        val response = consultaCore.compararDadosDoCore(idServico.toLong())

        if (!response.contains("ERRO")) {
            return ResponseEntity<String>("Dados do core estão iguais ${response}", HttpStatus.OK)
        } else {
            return ResponseEntity<String>(response.replace("ERRO", ""), HttpStatus.BAD_REQUEST)
        }
    }
}

class ServicoRequest {
    var id : Long = 0
    var nome : String = ""
    var tipoServico : String = ""
    var sinceID : String = ""
    var todasPalavras : String = ""
    var algumasPalavras : String = ""
    var nenhumaPalavras : String = ""
    var url : String = ""
}

class ServicoResponse {
    var msg: String = ""
    var data : MutableList<DataServico> = mutableListOf()
}

class DataServico {
    var id: Long = 0
    var nome: String = ""
    var tipoServico: String = ""
    var sinceID : String = ""
    var todasPalavras : String = ""
    var algumasPalavras : String = ""
    var nenhumaPalavras : String = ""
    var url : String = ""
}


class ResultadoResponse {
    var sinceID : String = ""

    val resultadoBuscaResponse : MutableList<ResultadoBuscaResponse> = mutableListOf()
}

class ResultadoBuscaResponse {
    var id : String? = ""
    var filtrada : Boolean = false
    var autorNome : String? = ""
    var autorNomeCompleto : String? = ""
    var autorParaNome : String? = ""
    var autorParaNomeCompleto : String? = ""
    var titulo : String? = ""
    var descricao : String? = ""
}
