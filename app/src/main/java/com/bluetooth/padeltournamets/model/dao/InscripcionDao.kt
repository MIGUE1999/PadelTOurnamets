package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.InscripcionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InscripcionDao {
    @Query("SELECT * FROM InscripcionEntity")
    fun getAllInscripcion() : Flow<List<InscripcionEntity>>

    @Query("SELECT * FROM InscripcionEntity WHERE id = :idInscripcion")
    fun getInscripcionById(idInscripcion: Int) : Flow<InscripcionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInscripcion(inscripcionEntity: InscripcionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInscripciones(inscripcionEntity: List<InscripcionEntity>)

    @Update
    suspend fun updateInscripcion(inscripcionEntity: InscripcionEntity)

    @Delete
    suspend fun deleteInscripcion(inscripcionEntity: InscripcionEntity)

    @Delete
    suspend fun deleteInscripciones(inscripciones: List<InscripcionEntity>)
}