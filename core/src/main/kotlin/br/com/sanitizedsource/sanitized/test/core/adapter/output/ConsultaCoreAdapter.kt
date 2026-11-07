package br.com.sanitizedsource.sanitized.test.core.adapter.output

import br.com.sanitizedsource.sanitized.test.core.adapter.input.ResultadoResponse
import br.com.sanitizedsource.sanitized.test.core.application.port.output.ConsultaCorePortOutput
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ConsultaCoreAdapter : ConsultaCorePortOutput {

    override fun buscar(request: ConsultaCorePortOutput.CoreRequest, urlServer: String): ResultadoResponse {
        val restTemplate = RestTemplate()
        return restTemplate.postForObject(urlServer, request, ResultadoResponse::class.java) ?: ResultadoResponse()
    }
}
