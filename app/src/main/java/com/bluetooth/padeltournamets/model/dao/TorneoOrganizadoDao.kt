package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.TorneoOrganizadoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TorneoOrganizadoDao {
    @Query("SELECT * FROM TorneoOrganizadoEntity")
    fun getAllTorneoOrganizado() : Flow<List<TorneoOrganizadoEntity>>

    @Query("SELECT * FROM TorneoOrganizadoEntity WHERE id = :idTorneoOrganizado")
    fun getTorneoOrganizadoById(idTorneoOrganizado: Int) : Flow<TorneoOrganizadoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTorneoOrganizado(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>)

    @Update
    suspend fun updateTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)

    @Delete
    suspend fun deleteTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity)

    @Delete
    suspend fun deleteTorneosOrganizados(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>)
}