package br.com.sanitizedsource.sanitized.test.core.application.services

import br.com.sanitizedsource.sanitized.test.core.application.port.input.ServicoPortInput
import br.com.sanitizedsource.sanitized.test.core.application.port.output.ServicoPortOutput
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServicoUseCase(@Autowired private val servicoPort: ServicoPortOutput) : ServicoPortInput {

    override fun listar(): MutableList<Servico> {
       return servicoPort.listar()
    }

    override fun salvar(servico: Servico): Servico {
       return servicoPort.salvar(servico)
    }

    override fun atualizar(servico: Servico): Servico {
        return servicoPort.atualizar(servico)
    }

    override fun remover(id: Long) {
        val servico = Servico()
        servico.id = id
        servicoPort.remover(servico)
    }
}
