package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.PistaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PistaDao {

    @Query("SELECT * FROM PistaEntity")
    fun getAllPistas() : Flow<List<PistaEntity>>

    @Query("SELECT * FROM PistaEntity WHERE id = :idPista")
    fun getPistaById(idPista: Int) : Flow<PistaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPista(pistaEntity: PistaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPistas(pistaEntities: List<PistaEntity>)

    @Update
    suspend fun updatePista(pistaEntity: PistaEntity)

    @Delete
    suspend fun deletePista(pistaEntity: PistaEntity)

    @Delete
    suspend fun deletePistas(pistaEntities: List<PistaEntity>)
}