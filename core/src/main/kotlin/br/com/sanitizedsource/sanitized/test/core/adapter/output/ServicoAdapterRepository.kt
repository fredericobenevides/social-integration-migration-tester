package br.com.sanitizedsource.sanitized.test.core.adapter.output

import br.com.sanitizedsource.sanitized.test.core.application.port.output.ServicoPortOutput
import br.com.sanitizedsource.sanitized.test.core.domain.model.Servico
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ServicoAdapterRepository(@Autowired private val repository: ServicoRepository) : ServicoPortOutput {

    override fun listar(): MutableList<Servico> {
        val findAll = repository.findAllByOrderByTipoServicoAscNomeAsc()

        val listaServicos : MutableList<Servico> = mutableListOf()

        for (servicoDB in findAll) {
            val modelMapper = ModelMapper()

            val servico = modelMapper.map(servicoDB, Servico::class.java)
            listaServicos.add(servico)
        }

        return listaServicos
    }

    override fun salvar(servico: Servico): Servico {
        val modelMapper = ModelMapper()

        val servicoDB = modelMapper.map(servico, ServicoDB::class.java)
        return salvarServico(servicoDB)
    }

    override fun atualizar(servico: Servico): Servico {
        val modelMapper = ModelMapper()

        val servicoDB = modelMapper.map(servico, ServicoDB::class.java)
        return salvarServico(servicoDB)
    }

    override fun remover(servico: Servico) {
        repository.deleteById(servico.id)
    }

    override fun findById(idServico: Long): Servico {
        val findById = repository.findById(idServico)
        if (findById.isPresent) {
            val modelMapper = ModelMapper()

            val servicoDB = findById.get()
            return modelMapper.map(servicoDB, Servico::class.java)
        }

        throw RuntimeException("Não foi possível localizar o serviço")
    }

    private fun salvarServico(servicoDB : ServicoDB) : Servico {
        val modelMapper = ModelMapper()

        val servicoDB = repository.save(servicoDB)
        return modelMapper.map(servicoDB, Servico::class.java)
    }
}