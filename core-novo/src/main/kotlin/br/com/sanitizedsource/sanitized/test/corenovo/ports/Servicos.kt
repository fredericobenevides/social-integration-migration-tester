package br.com.sanitizedsource.sanitized.test.corenovo.ports

import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados

interface ServicoBusca {

    fun busca(filtros: Filtros): Resultados
}