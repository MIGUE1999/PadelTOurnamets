package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.PagoEntity
import kotlinx.coroutines.flow.Flow

interface IPagoRepository {

    fun getAllParejas() : Flow<List<PagoEntity>>
    fun getPagoById(idPago: Int) : Flow<PagoEntity>

    suspend fun insertPago(pagoEntity: PagoEntity)

    suspend fun insertPagos(pagoEntities: List<PagoEntity>)

    suspend fun updatePago(pagoEntity: PagoEntity)

    suspend fun deletePago(pagoEntity: PagoEntity)

    suspend fun deletePagos(pagoEntities: List<PagoEntity>)
}