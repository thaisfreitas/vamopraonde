package com.exemplo.vamopraonde.service

import com.exemplo.vamopraonde.model.Local
import com.exemplo.vamopraonde.repository.LocalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocalService @Autowired constructor(
    private val localRepository: LocalRepository
) {

    fun criarLocal(local: Local): Local {
        return localRepository.save(local)
    }

    fun listarLocais(): List<Local> {
        return localRepository.findAll()
    }

    fun buscarLocalPorNome(nome: String): List<Local> {
        return localRepository.findByNome(nome)
    }

    fun editarLocal(id: Long, local: Local): Local? {
        return if (localRepository.existsById(id)) {
            localRepository.save(local.copy(id = id))
        } else {
            null
        }
    }

    fun excluirLocal(id: Long) {
        if (localRepository.existsById(id)) {
            localRepository.deleteById(id)
        }
    }
}
