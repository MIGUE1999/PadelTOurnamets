package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.TorneoOrganizadoEntity
import kotlinx.coroutines.flow.Flow

interface ITorneoOrganizadoRepository {


    fun getAllTorneoOrganizado() : Flow<List<TorneoOrganizadoEntity>>

    fun getTorneoOrganizadoById(idTorneoOrganizado: Int) : Flow<TorneoOrganizadoEntity>

    suspend fun insertTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)

    suspend fun insertTorneoOrganizado(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>)

    suspend fun updateTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)


    suspend fun deleteTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)


    suspend fun deleteTorneosOrganizados(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>)
}