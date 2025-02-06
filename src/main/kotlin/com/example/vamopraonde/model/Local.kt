package com.exemplo.vamopraonde.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="locais")
data class Local(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val tipo: String,
    val endereco: String,
    val link: String?,
    val observacoes: String?
)
