package br.com.sanitizedsource.sanitized.test.coreantigo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.facebook.ServicoFacebook
import br.com.sanitizedsource.sanitized.core.servicos.social.facebook.ServicoFacebookAnuncios
import br.com.sanitizedsource.sanitized.core.servicos.social.facebook.TipoServicoFacebook
import br.com.sanitizedsource.sanitized.test.coreantigo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaFacebookPostsPages : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.POSTS_PAGE).buscar(filtros)
    }
}

class BuscaFacebookCommentsPage : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.COMMENTS_PAGE).buscar(filtros)
    }
}

class BuscaFacebookPost : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.POST).buscar(filtros)
    }
}

class BuscaFacebookMessages : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.MAIL_BOX).buscar(filtros)
    }
}

class BuscaFacebookRating : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.RATINGS).buscar(filtros)
    }
}

class BuscaFacebookTagged : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebook.instance(TipoServicoFacebook.TAGGED).buscar(filtros)
    }
}

class BuscaFacebookAnuncios : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoFacebookAnuncios.instance().buscar(filtros)
    }
}
