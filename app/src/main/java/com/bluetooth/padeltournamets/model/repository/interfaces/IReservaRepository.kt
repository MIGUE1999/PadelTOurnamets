package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.ReservaEntity
import kotlinx.coroutines.flow.Flow

interface IReservaRepository {

    fun getAllReserva() : Flow<List<ReservaEntity>>

    fun getReservaById(idReserva: Int) : Flow<ReservaEntity>

    suspend fun insertReserva(reservaEntity: ReservaEntity)

    suspend fun insertReservas(reservaEntities: List<ReservaEntity>)

    suspend fun updateReserva(reservaEntity: ReservaEntity)

    suspend fun deleteReserva(reservaEntity: ReservaEntity)

    suspend fun deletereservas(reservaEntities: List<ReservaEntity>)
}