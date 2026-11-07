package br.com.sanitizedsource.sanitized.test.corenovo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.facebook.*
import br.com.sanitizedsource.sanitized.core.servicos.social.twitter.ServicoTwitterTweetSearch
import br.com.sanitizedsource.sanitized.test.corenovo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.ResultadoBusca
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaFacebookPostsPages : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoFacebookFeed.instance(TipoServicoFacebookFeed.PAGE_FEED).buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaFacebookCommentsPage : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoFacebookFeed.instance(TipoServicoFacebookFeed.PAGE_FEED_AND_COMMENTS).buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaFacebookPost : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoFacebookComments.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaFacebookMessages : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoFacebookConversations.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaFacebookRating : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoFacebookRatings.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaFacebookTagged : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoFacebookTagged.instance().buscar(filtros)

        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaFacebookAnuncios : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoFacebookAnuncios.instance().buscar(filtros)

        return Resultados(resultados.sinceId, resultados.resultados)
    }
}
