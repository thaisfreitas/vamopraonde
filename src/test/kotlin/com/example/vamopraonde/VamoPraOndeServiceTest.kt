package com.example.vamopraonde

import com.exemplo.vamopraonde.model.Local
import com.exemplo.vamopraonde.repository.LocalRepository
import com.exemplo.vamopraonde.service.LocalService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals


@ExtendWith(MockitoExtension::class)
class VamoPraOndeServiceTest {

    @Mock
    lateinit var localRepository: LocalRepository

    @InjectMocks
    lateinit var localService: LocalService

    @Test
    fun `should Add Place` () {
        val local = Local(
            nome = "vovo bistro",
            tipo = "restaurante",
            endereco = "ao lado da casa da vovo",
            link = "wwww",
            observacoes = "tem parquinho"
        )
        whenever(localRepository.save(local)).thenReturn(local)

        val saveLocal = localService.criarLocal(local)

        assertEquals(local, saveLocal);
        verify(localRepository).save(local)
    }

    @Test
    fun `should fech all places`() {
        val locais = listOf(
            Local(nome = "Praia A", tipo = "Praia", endereco = "Praia A", link = "", observacoes = ""),
            Local(nome = "Praia B", tipo = "Praia", endereco = "Praia B", link = "", observacoes = "")
            )
        whenever(localRepository.findAll()).thenReturn(locais)

        val listarLocais = localService.listarLocais()

        assertEquals(locais, listarLocais)
        verify(localRepository).findAll()
    }

}