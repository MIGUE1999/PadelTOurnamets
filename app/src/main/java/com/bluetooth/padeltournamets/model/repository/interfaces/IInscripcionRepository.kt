package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.InscripcionEntity
import kotlinx.coroutines.flow.Flow

interface IInscripcionRepository {

    fun getAllInscripcion() : Flow<List<InscripcionEntity>>

    fun getInscripcionById(idInscripcion: Int) : Flow<InscripcionEntity>

    suspend fun insertInscripcion(inscripcionEntity: InscripcionEntity)

    suspend fun insertInscripciones(inscripcionEntity: List<InscripcionEntity>)

    suspend fun updateInscripcion(inscripcionEntity: InscripcionEntity)

    suspend fun deleteInscripcion(inscripcionEntity: InscripcionEntity)

    suspend fun deleteInscripciones(inscripciones: List<InscripcionEntity>)
}