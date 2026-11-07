package br.com.sanitizedsource.sanitized.test.corenovo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.instagram.*
import br.com.sanitizedsource.sanitized.core.servicos.social.instagram.graph.*
import br.com.sanitizedsource.sanitized.test.corenovo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados
import br.com.sanitized.core.entidades.entidades.enums.TipoServico

class BuscaInstagramTags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramTag.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramPerfilPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramFeed.instance(TipoServicoInstagramFeed.FEED).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramPerfilComments : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramFeed.instance(TipoServicoInstagramFeed.FEED_AND_COMMENTS).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

//class BuscaInstagramPost : ServicoBusca {
//
//    override fun busca(filtros: Filtros): Resultados {
//        return ServicoInstagram.instance(TipoServicoInstagram.POST_COMMENTS).buscar(filtros)
//    }
//}

class BuscaInstagramBusinessUser : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramBusinessDiscovery.instance(TipoServico.instagram_business_user).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramBusinessPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramBusinessDiscovery.instance(TipoServico.instagram_business_posts).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramMyBusinessPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramUserMedia.instance(TipoServico.instagram_my_business_posts).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramMyBusinessPostsAndComments : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramUserMedia.instance(TipoServico.instagram_my_business_posts_and_comments).buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramMyBusinessStories : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramUserStories.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramMyBusinessTags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramUserTaggedMedia.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaInstagramBusinessHashtags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoInstagramHashtagSearch.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}
