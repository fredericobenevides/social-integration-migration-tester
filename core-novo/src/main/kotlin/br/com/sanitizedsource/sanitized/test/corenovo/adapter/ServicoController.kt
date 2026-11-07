package br.com.sanitizedsource.sanitized.test.corenovo.adapter

import br.com.sanitizedsource.utils.entidades.TipoLinguagem
import br.com.sanitizedsource.sanitized.test.corenovo.servicos.*
import br.com.sanitized.core.entidades.entidades.Filtros
import br.com.sanitized.core.entidades.entidades.Resultados
import br.com.sanitized.core.entidades.entidades.enums.TipoServico
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("core_novo")
class ServicoController {

    @PostMapping("busca")
    fun busca(@RequestBody busca : BuscaRequest) : ResultadoResponse {
        val filtros = Filtros()
        filtros.sinceId = busca.sinceID
        filtros.url = busca.url
        filtros.pageAccessToken = busca.pageAccessToken
        filtros.accessToken = busca.accessToken
        filtros.refreshToken = busca.refreshToken
        filtros.usuarioId = busca.usuarioId
        filtros.tag = busca.tag

        if (filtros.linguagem == null) {
            filtros.linguagem = TipoLinguagem.QR
        }

        if (!busca.todasPalavras.isEmpty()) {
            filtros.todasPalavras = busca.todasPalavras.split(",").map { s -> "${s.trim()}" }.toTypedArray()
        }
        if (!busca.algumasPalavras.isEmpty()) {
            filtros.algumasPalavras = busca.algumasPalavras.split(",").map { s -> "${s.trim()}" }.toTypedArray()
        }
        if (!busca.nenhumaPalavras.isEmpty()) {
            filtros.nenhumaPalavras = busca.nenhumaPalavras.split(",").map { s -> "${s.trim()}" }.toTypedArray()
        }

        var resultados : Resultados? = null

        val tipoServico = getTipoServico(busca.tipoServico)

        when(tipoServico) {

            TipoServico.facebook_posts_page -> resultados = BuscaFacebookPostsPages().busca(filtros)
            TipoServico.facebook_comments_page -> resultados = BuscaFacebookCommentsPage().busca(filtros)
            TipoServico.facebook_post -> resultados = BuscaFacebookPost().busca(filtros)
            TipoServico.facebook_messages -> resultados = BuscaFacebookMessages().busca(filtros)
            TipoServico.facebook_rating -> resultados = BuscaFacebookRating().busca(filtros)
            TipoServico.facebook_tagged -> resultados = BuscaFacebookTagged().busca(filtros)
            TipoServico.facebook_anuncios -> resultados = BuscaFacebookAnuncios().busca(filtros)


//            TipoServico.instagram_tags -> resultados = BuscaInstagramTags().busca(filtros)
//            TipoServico.instagram_perfil_posts -> resultados = BuscaInstagramPerfilPosts().busca(filtros)
//            TipoServico.instagram_perfil_comments -> resultados = BuscaInstagramPerfilPosts().busca(filtros)
//            TipoServico.instagram_post -> resultados = BuscaInstagramPerfilPost().busca(filtros) // no novo tá comentado
            TipoServico.instagram_business_user -> resultados = BuscaInstagramBusinessUser().busca(filtros)
            TipoServico.instagram_business_posts -> resultados = BuscaInstagramBusinessPosts().busca(filtros)
            TipoServico.instagram_my_business_posts -> resultados = BuscaInstagramMyBusinessPosts().busca(filtros)
            TipoServico.instagram_my_business_posts_and_comments -> resultados = BuscaInstagramMyBusinessPostsAndComments().busca(filtros)
            TipoServico.instagram_my_business_stories -> resultados = BuscaInstagramMyBusinessStories().busca(filtros)
            TipoServico.instagram_my_business_tags -> resultados = BuscaInstagramMyBusinessTags().busca(filtros)
            TipoServico.instagram_business_hashtags -> resultados = BuscaInstagramBusinessHashtags().busca(filtros)


            TipoServico.twitter ->  resultados = BuscaTwitter().busca(filtros)
            TipoServico.twitter_messages ->  resultados = BuscaTwitterMessages().busca(filtros)
            TipoServico.twitter_perfil ->  resultados = BuscaTwitterPerfil().busca(filtros)
            TipoServico.twitter_tweet ->  resultados = BuscaTwitterTweet().busca(filtros)
            TipoServico.twitter_tweets_perfil ->  resultados = BuscaTwitterTweetsPerfil().busca(filtros)


            TipoServico.youtube_canal -> resultados = BuscaYoutubeCanal().busca(filtros)
            TipoServico.youtube_comentarios_canal -> resultados = BuscaYoutubeComentariosCanal().busca(filtros)
            TipoServico.youtube_videos -> resultados = BuscaYoutubeVideos().busca(filtros)
            TipoServico.youtube_comentarios -> resultados = BuscaYoutubeComentarios().busca(filtros)


            TipoServico.app_store -> resultados = BuscaAppStore().busca(filtros)
            TipoServico.blogs -> resultados = BuscaBlogs().busca(filtros)
            TipoServico.reclameaqui_pagina -> resultados = BuscaReclameAquiPagina().busca(filtros)
            TipoServico.reclameaqui_empresa -> resultados = BuscaReclameAquiEmpresa().busca(filtros)
            TipoServico.reclameaqui_geral -> resultados = BuscaReclameAquiGeral().busca(filtros)

            TipoServico.google -> resultados = BuscaGoogle().busca(filtros)
            TipoServico.google_alerts -> resultados = BuscaGoogleAlerts().busca(filtros)
            TipoServico.google_my_business -> resultados = BuscaGoogleMyBusiness().busca(filtros)
            TipoServico.googlenews -> resultados = BuscaGoogleNews().busca(filtros)

            TipoServico.wordpress_comments -> resultados = BuscaWordpressComments().busca(filtros)
            TipoServico.wordpress_posts -> resultados = BuscaWordpressPosts().busca(filtros)
        }

        println("Resultados retornado para o serviço ${busca.tipoServico} = ${tipoServico.nome}")

//        return resultados
        return criarResultadoBuscaResponse(resultados)
    }
}

class BuscaRequest {
    var tipoServico : String = ""
    var sinceID : String = ""
    var todasPalavras : String = ""
    var algumasPalavras : String = ""
    var nenhumaPalavras : String = ""
    var url : String? = ""
    var pageAccessToken : String? = ""
    var accessToken: String? = ""
    var refreshToken : String? = ""
    var usuarioId : String? = ""
    val tag: String? = ""
}

fun getTipoServico(tipoServico: String): TipoServico {
    val values = TipoServico.values()
    for (v in values) {
        if (v.name == tipoServico) {
            return v
        }
    }

    throw RuntimeException("O serviço $tipoServico não está mapeado")
}

class ResultadoResponse {
    var sinceID : String = ""

    val resultadoBuscaResponse : MutableList<ResultadoBuscaResponse> = mutableListOf()
}

class ResultadoBuscaResponse {
    var id : String? = ""
    var filtrada: Boolean = false
    var autorNome : String? = ""
    var autorNomeCompleto : String? = ""
    var autorParaNome : String? = ""
    var autorParaNomeCompleto : String? = ""
    var titulo : String? = ""
    var descricao : String? = ""
}

fun criarResultadoBuscaResponse(resultados: Resultados?): ResultadoResponse {
    var resultadoResponse = ResultadoResponse()
    resultadoResponse.sinceID = resultados?.sinceId ?: ""

    var todosResultados = resultados?.resultados ?: arrayListOf()

    for (rb in todosResultados) {
        val resultadoBuscaResponse = ResultadoBuscaResponse()

        resultadoBuscaResponse.id = rb.idOcorrenciaServico
        resultadoBuscaResponse.filtrada = rb.filtrada

        resultadoBuscaResponse.autorNome = rb.autor?.nome
        resultadoBuscaResponse.autorNomeCompleto = rb.autor?.nomeCompleto

        resultadoBuscaResponse.autorParaNome = rb.autorPara?.nome
        resultadoBuscaResponse.autorParaNomeCompleto = rb.autorPara?.nomeCompleto

        resultadoBuscaResponse.descricao = rb.descricao
        resultadoBuscaResponse.titulo = rb.titulo

        resultadoResponse.resultadoBuscaResponse.add(resultadoBuscaResponse)
    }

    return resultadoResponse
}
