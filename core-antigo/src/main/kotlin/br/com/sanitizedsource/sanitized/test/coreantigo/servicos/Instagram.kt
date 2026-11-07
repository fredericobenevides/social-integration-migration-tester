package br.com.sanitizedsource.sanitized.test.coreantigo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.instagram.ServicoInstagram
import br.com.sanitizedsource.sanitized.core.servicos.social.instagram.TipoServicoInstagram
import br.com.sanitizedsource.sanitized.core.servicos.social.instagram.graph.*
import br.com.sanitizedsource.sanitized.test.coreantigo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados
import br.com.sanitized.core.entidades.entidades.enums.TipoServico

class BuscaInstagramTags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagram.instance(TipoServicoInstagram.TAGS).buscar(filtros)
    }
}

class BuscaInstagramPerfilPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagram.instance(TipoServicoInstagram.PERFIL_POSTS).buscar(filtros)
    }
}

class BuscaInstagramPerfilComments : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagram.instance(TipoServicoInstagram.PERFIL_COMMENTS).buscar(filtros)
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
        return ServicoInstagramBusinessDiscovery.instance(TipoServico.instagram_business_user).buscar(filtros)
    }
}

class BuscaInstagramBusinessPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramBusinessDiscovery.instance(TipoServico.instagram_business_posts).buscar(filtros)
    }
}

class BuscaInstagramMyBusinessPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramUserMedia.instance(TipoServico.instagram_my_business_posts).buscar(filtros)
    }
}

class BuscaInstagramMyBusinessPostsAndComments : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramUserMedia.instance(TipoServico.instagram_my_business_posts_and_comments).buscar(filtros)
    }
}

class BuscaInstagramMyBusinessStories : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramUserStories.instance().buscar(filtros)
    }
}

class BuscaInstagramMyBusinessTags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramUserTaggedMedia.instance().buscar(filtros)
    }
}

class BuscaInstagramBusinessHashtags : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoInstagramHashtagSearch.instance().buscar(filtros)
    }
}
