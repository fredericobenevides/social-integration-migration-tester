package br.com.sanitizedsource.sanitized.test.corenovo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.base.google.ServicoGoogle
import br.com.sanitizedsource.sanitized.core.servicos.blogs.webhose.ServicoWebHose
import br.com.sanitizedsource.sanitized.core.servicos.blogs.wordpress.ServicoWordpress
import br.com.sanitizedsource.sanitized.core.servicos.blogs.wordpress.TipoServicoWordpress
import br.com.sanitizedsource.sanitized.core.servicos.midia.googlenews.ServicoGoogleNews
import br.com.sanitizedsource.sanitized.core.servicos.reviews.googlemybusiness.ServicoGoogleMyBusiness
import br.com.sanitizedsource.sanitized.core.servicos.social.googlealerts.ServicoGoogleAlerts
import br.com.sanitizedsource.sanitized.core.servicos.social.reclameaqui.ServicoReclameAquiCompaniesSearch
import br.com.sanitizedsource.sanitized.core.servicos.social.reclameaqui.ServicoReclameAquiCompanyComplaintsFeed
import br.com.sanitizedsource.sanitized.core.servicos.social.reclameaqui.ServicoReclameAquiComplaintsSearch
import br.com.sanitizedsource.sanitized.core.servicos.stores.appstore.ServicoAppStore
import br.com.sanitizedsource.sanitized.test.corenovo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.ResultadoBusca
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaAppStore : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val resultados = ServicoAppStore.instance().buscar(filtros)
        return Resultados(resultados.sinceId, resultados.resultados)
    }
}

class BuscaBlogs : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoWebHose.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaGoogle : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoGoogle.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
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
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoReclameAquiCompaniesSearch.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaReclameAquiGeral : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoReclameAquiComplaintsSearch.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
    }
}

class BuscaReclameAquiPagina : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        val totalResultadoBusca = mutableListOf<ResultadoBusca?>()

        val resultados = ServicoReclameAquiCompanyComplaintsFeed.instance().buscar(filtros) { paginaAtual, resultadoPorPagina, sinceID -> totalResultadoBusca.addAll(resultadoPorPagina) }

        return Resultados(resultados.sinceId, totalResultadoBusca)
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
