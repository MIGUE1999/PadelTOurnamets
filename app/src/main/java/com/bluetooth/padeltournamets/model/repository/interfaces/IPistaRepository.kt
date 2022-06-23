package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.PistaEntity
import kotlinx.coroutines.flow.Flow

interface IPistaRepository {

    fun getAllPistas() : Flow<List<PistaEntity>>

    fun getPistaById(idPista: Int) : Flow<PistaEntity>

    suspend fun insertPista(pistaEntity: PistaEntity)

    suspend fun insertPistas(pistaEntities: List<PistaEntity>)

    suspend fun updatePista(pistaEntity: PistaEntity)

    suspend fun deletePista(pistaEntity: PistaEntity)

    suspend fun deletePistas(pistaEntities: List<PistaEntity>)
}