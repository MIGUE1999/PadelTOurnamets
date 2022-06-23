package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.OrganizadorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OrganizadorDao {
    @Query("SELECT * FROM OrganizadorEntity")
    fun getAllOrganizadores() : Flow<List<OrganizadorEntity>>

    @Query("SELECT * FROM OrganizadorEntity WHERE id = :idOrganizador")
    fun getOrganizadorById(idOrganizador: Int) : Flow<OrganizadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrganizador(organizadorModel: OrganizadorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrganizadores(organizadores: List<OrganizadorEntity>)

    @Update
    suspend fun updateOrganizador(organizadorModel: OrganizadorEntity)

    @Delete
    suspend fun deleteOrganizador(organizadorModel: OrganizadorEntity)

    @Delete
    suspend fun deleteOrganizadores(organizadores: List<OrganizadorEntity>)
}