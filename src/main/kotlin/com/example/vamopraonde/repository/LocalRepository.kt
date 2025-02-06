package com.exemplo.vamopraonde.repository

import com.exemplo.vamopraonde.model.Local
import org.springframework.data.jpa.repository.JpaRepository


interface LocalRepository : JpaRepository<Local, Long>
{    fun findByNome(nome: String): List<Local>}

