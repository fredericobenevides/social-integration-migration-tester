package br.com.sanitizedsource.sanitized.test.corenovo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.ServicoYouTubeChannel
import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.ServicoYouTubeChannelComments
import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.ServicoYouTubeVideosSearch
import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.ServicoYoutubeVideoComments
import br.com.sanitizedsource.sanitized.test.corenovo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaYoutubeCanal : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoYouTubeChannel.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaYoutubeComentarios : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoYoutubeVideoComments.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaYoutubeComentariosCanal : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoYouTubeChannelComments.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaYoutubeVideos : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoYouTubeVideosSearch.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}
