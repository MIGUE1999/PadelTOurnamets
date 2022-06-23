package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.EnfrentamientoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EnfrentamientoDao {
    @Query("SELECT * FROM EnfrentamientoEntity")
    fun getAllEnfrentamiento(): Flow<List<EnfrentamientoEntity>>

    @Query("SELECT * FROM EnfrentamientoEntity WHERE id = :idEnfrentamiento")
    fun getEnfrentamientoById(idEnfrentamiento: Int): Flow<EnfrentamientoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEnfrentamientos(enfrentamientoEntity: List<EnfrentamientoEntity>)

    @Update
    suspend fun updateEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    @Delete
    suspend fun deleteEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity)

    @Delete
    suspend fun deleteEnfrentamientos(enfrentamientoEntities: List<EnfrentamientoEntity>)
}