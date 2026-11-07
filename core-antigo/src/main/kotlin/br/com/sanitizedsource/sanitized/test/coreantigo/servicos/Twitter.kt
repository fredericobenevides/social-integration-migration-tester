package br.com.sanitizedsource.sanitized.test.coreantigo.servicos

import br.com.sanitizedsource.sanitized.core.servicos.social.twitter.ServicoTwitter
import br.com.sanitizedsource.sanitized.core.servicos.social.twitter.TipoServicoTwitter
import br.com.sanitizedsource.sanitized.test.coreantigo.ports.ServicoBusca
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados

class BuscaTwitter : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoTwitter.instance(null, null, TipoServicoTwitter.TWEETS).buscar(filtros)
    }
}

class BuscaTwitterMessages : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoTwitter.instance(null, null, TipoServicoTwitter.DM).buscar(filtros)
    }
}

class BuscaTwitterPerfil : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoTwitter.instance(null, null, TipoServicoTwitter.PROFILE).buscar(filtros)
    }
}

class BuscaTwitterTweet : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoTwitter.instance(null, null, TipoServicoTwitter.TWEET).buscar(filtros)
    }
}

class BuscaTwitterTweetsPerfil : ServicoBusca {

    override fun busca(filtros: Filtros): Resultados {
        return ServicoTwitter.instance(null, null, TipoServicoTwitter.TWEETS_PERFIL).buscar(filtros)
    }
}
