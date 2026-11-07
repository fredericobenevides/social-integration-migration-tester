package br.com.sanitizedsource.sanitized.test.coreantigo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.base.google.ServicoGoogle
import br.com.sanitizedsource.sanitized.core.servicos.blogs.webhose.ServicoWebHose
import br.com.sanitizedsource.sanitized.core.servicos.blogs.wordpress.ServicoWordpress
import br.com.sanitizedsource.sanitized.core.servicos.blogs.wordpress.TipoServicoWordpress
import br.com.sanitizedsource.sanitized.core.servicos.midia.googlenews.ServicoGoogleNews
import br.com.sanitizedsource.sanitized.core.servicos.reviews.googlemybusiness.ServicoGoogleMyBusiness
import br.com.sanitizedsource.sanitized.core.servicos.social.googlealerts.ServicoGoogleAlerts
import br.com.sanitizedsource.sanitized.core.servicos.social.reclameaqui.ServicoReclameAqui
import br.com.sanitizedsource.sanitized.core.servicos.social.reclameaqui.TipoServicoReclameAqui
import br.com.sanitizedsource.sanitized.core.servicos.stores.appstore.ServicoAppStore
import br.com.sanitizedsource.sanitized.test.coreantigo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.ResultadoBusca
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaAppStore : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoAppStore.instance().buscar(filtros)
    }
}

class BuscaBlogs : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoWebHose.instance().buscar(filtros)
    }
}

class BuscaGoogle : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoGoogle.instance().buscar(filtros)
    }
}

class BuscaGoogleAlerts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoGoogleAlerts.instance().buscar(filtros)
    }
}

class BuscaGoogleMyBusiness : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoGoogleMyBusiness.instance().buscar(filtros)
    }
}

class BuscaGoogleNews : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoGoogleNews.instance().buscar(filtros)
    }
}

class BuscaReclameAquiEmpresa : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoReclameAqui.instance(TipoServicoReclameAqui.PAGINA).buscar(filtros)
    }
}

class BuscaReclameAquiGeral : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoReclameAqui.instance(TipoServicoReclameAqui.PAGINA).buscar(filtros)
    }
}

class BuscaReclameAquiPagina : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoReclameAqui.instance(TipoServicoReclameAqui.PAGINA).buscar(filtros)
    }
}


class BuscaWordpressComments : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoWordpress.instance(TipoServicoWordpress.COMMENTS).buscar(filtros)
    }
}

class BuscaWordpressPosts : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoWordpress.instance(TipoServicoWordpress.POSTS).buscar(filtros)
    }
}
