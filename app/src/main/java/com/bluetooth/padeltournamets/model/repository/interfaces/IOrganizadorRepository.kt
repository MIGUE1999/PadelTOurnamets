package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.OrganizadorEntity
import kotlinx.coroutines.flow.Flow

interface IOrganizadorRepository {

    fun getAllOrganizadores() : Flow<List<OrganizadorEntity>>

    fun getOrganizadorById(idOrganizador: Int) : Flow<OrganizadorEntity>

    suspend fun insertOrganizador(organizadorModel: OrganizadorEntity)

    suspend fun insertOrganizadores(organizadores: List<OrganizadorEntity>)

    suspend fun updateOrganizador(organizadorModel: OrganizadorEntity)

    suspend fun deleteOrganizador(organizadorModel: OrganizadorEntity)

    suspend fun deleteOrganizadores(organizadores: List<OrganizadorEntity>)
}