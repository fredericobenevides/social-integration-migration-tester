package br.com.sanitizedsource.sanitized.test.core.application.port.input

interface ConsultaCorePortInput {
    fun compararDadosDoCore(idServico : Long) : String
}
