package br.com.sanitizedsource.sanitized.test.core.application.port.input

import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico

interface ServicoPortInput {

    fun listar() : MutableList<Servico>
    fun salvar(servico : Servico) : Servico
    fun atualizar(servico : Servico) : Servico
    fun remover(id: Long)

}