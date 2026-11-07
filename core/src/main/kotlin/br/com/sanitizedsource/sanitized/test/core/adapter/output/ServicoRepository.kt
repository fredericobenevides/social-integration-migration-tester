package br.com.sanitizedsource.sanitized.test.core.adapter.output

import br.com.sanitizedsource.sanitized.test.core.application.port.output.ServicoPortOutput
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.*

@Repository
interface ServicoRepository : JpaRepository<ServicoDB, Long> {

    fun findAllByOrderByTipoServicoAscNomeAsc() : MutableList<ServicoDB>
}

@Entity(name = "servico")
class ServicoDB {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long = 0

    @Column(nullable = false)
    var nome : String = ""

    @Column(nullable = false)
    var tipoServico : String = ""

    @Column
    var sinceID : String = ""

    @Column
    var todasPalavras : String = ""

    @Column
    var algumasPalavras : String = ""

    @Column
    var nenhumaPalavras : String = ""

    @Column
    var url : String = ""
}
