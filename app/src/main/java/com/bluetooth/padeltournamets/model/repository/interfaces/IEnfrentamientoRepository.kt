package com.bluetooth.padeltournamets.model.repository.interfaces

import com.bluetooth.padeltournamets.model.entities.EnfrentamientoEntity
import kotlinx.coroutines.flow.Flow

interface IEnfrentamientoRepository {

    fun getAllEnfrentamiento(): Flow<List<EnfrentamientoEntity>>

    fun getEnfrentamientoById(idEnfrentamiento: Int): Flow<EnfrentamientoEntity>

    suspend fun insertEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    suspend fun insertEnfrentamientos(enfrentamientoEntity: List<EnfrentamientoEntity>)

    suspend fun updateEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    suspend fun deleteEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    suspend fun deleteEnfrentamientos(enfrentamientoEntities: List<EnfrentamientoEntity>)
}