package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.TorneoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TorneoDao  {

    @Query("SELECT * FROM TorneoEntity")
    fun getAllTorneos() : Flow<List<TorneoEntity>>

    @Query("SELECT * FROM TorneoEntity WHERE id = :idTorneo")
    fun getTorneoById(idTorneo: Int) : Flow<TorneoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTorneo(torneoEntity: TorneoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTorneos(torneoEntities: List<TorneoEntity>)

    @Update
    suspend fun updateTorneo(torneoEntity: TorneoEntity)

    @Delete
    suspend fun deleteTorneo(torneoEntity: TorneoEntity)

    @Delete
    suspend fun deleteTorneos(torneoEntities: List<TorneoEntity>)
}