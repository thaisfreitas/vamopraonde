package com.exemplo.vamopraonde.controller

import com.exemplo.vamopraonde.model.Local
import com.exemplo.vamopraonde.service.LocalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/locais")
class LocalController @Autowired constructor(
    private val localService: LocalService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarLocal(@RequestBody local: Local): Local {
        return localService.criarLocal(local)
    }

    @GetMapping
    fun listarLocais(): List<Local> {
        return localService.listarLocais()
    }

    @GetMapping("/buscar")
    fun buscarLocalPorNome(@RequestParam nome: String): List<Local> {
        return localService.buscarLocalPorNome(nome)
    }

    @PutMapping("/{id}")
    fun editarLocal(@PathVariable id: Long, @RequestBody local: Local): Local? {
        return localService.editarLocal(id, local)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluirLocal(@PathVariable id: Long) {
        localService.excluirLocal(id)
    }
}
