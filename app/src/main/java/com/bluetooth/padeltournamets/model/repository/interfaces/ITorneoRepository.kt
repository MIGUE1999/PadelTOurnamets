package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.TorneoEntity
import kotlinx.coroutines.flow.Flow

interface ITorneoRepository {
    fun getAllTorneos() : Flow<List<TorneoEntity>>


    fun getTorneoById(idTorneo: Int) : Flow<TorneoEntity>


    suspend fun insertTorneo(torneoEntity: TorneoEntity)


    suspend fun insertTorneos(torneoEntities: List<TorneoEntity>)

    suspend fun updateTorneo(torneoEntity: TorneoEntity)

    suspend fun deleteTorneo(torneoEntity: TorneoEntity)

    suspend fun deleteTorneos(torneoEntities: List<TorneoEntity>)
}