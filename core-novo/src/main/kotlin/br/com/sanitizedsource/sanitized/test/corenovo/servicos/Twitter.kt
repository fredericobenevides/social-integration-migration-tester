package br.com.sanitizedsource.sanitized.test.corenovo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.twitter.*
import br.com.sanitizedsource.sanitized.test.corenovo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.ResultadoBusca
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaTwitter : ServicoBusca {

    override fun busca(filtros : Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoTwitterTweetSearch.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaTwitterMessages : ServicoBusca {

    override fun busca(filtros : Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoTwitterUserDirectMessages.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaTwitterPerfil : ServicoBusca {

    override fun busca(filtros : Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoTwitterUserTweetsAndRepliesAndMentions.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaTwitterTweet : ServicoBusca {

    override fun busca(filtros : Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoTwitterTweetReplies.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaTwitterTweetsPerfil : ServicoBusca {

    override fun busca(filtros : Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoTwitterUserTweets.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}
