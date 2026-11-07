package br.com.sanitizedsource.sanitized.test.core.application.port.output

import br.com.sanitizedsource.sanitized.test.core.adapter.input.ResultadoResponse

interface ConsultaCorePortOutput {

    fun buscar(request: CoreRequest, urlServer: String): ResultadoResponse

    class CoreRequest {
        var tipoServico: String = ""
        var sinceID : String = ""
        var todasPalavras : String = ""
        var algumasPalavras : String = ""
        var nenhumaPalavras : String = ""
        var url: String? = ""
        var pageAccessToken : String? = ""
        var accessToken : String? = ""
        var refreshToken: String? = ""
        var usuarioId : String? = ""
        var tag : String? = ""
    }
}