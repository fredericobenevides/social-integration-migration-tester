package br.com.sanitizedsource.sanitized.test.core.application.port.output

import br.com.sanitizedsource.sanitized.test.core.adapter.output.ServicoDB
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico

interface ServicoPortOutput {

    fun listar() : MutableList<Servico>
    fun salvar(servico: Servico) : Servico
    fun atualizar(servico: Servico) : Servico
    fun remover(servico: Servico)
    fun findById(idServico : Long) : Servico
}

