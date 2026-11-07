package br.com.sanitizedsource.sanitized.test.coreantigo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.ServicoYouTube
import br.com.sanitizedsource.sanitized.core.servicos.social.youtube.TipoServicoYouTube
import br.com.sanitizedsource.sanitized.test.coreantigo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaYoutubeCanal : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoYouTube.instance(TipoServicoYouTube.CANAL).buscar(filtros)
    }
}

class BuscaYoutubeComentarios : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoYouTube.instance(TipoServicoYouTube.COMENTARIOS).buscar(filtros)
    }
}

class BuscaYoutubeComentariosCanal : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoYouTube.instance(TipoServicoYouTube.COMENTARIOS_CANAL).buscar(filtros)
    }
}

class BuscaYoutubeVideos : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoYouTube.instance(TipoServicoYouTube.VIDEOS).buscar(filtros)
    }
}
