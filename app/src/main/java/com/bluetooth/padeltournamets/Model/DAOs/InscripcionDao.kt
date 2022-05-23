package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Inscripcion

@Dao
interface InscripcionDao {
    @Query("SELECT * FROM Inscripcion")
    fun getAllInscripcion() : Array<Inscripcion>

    @Query("SELECT * FROM Inscripcion WHERE id = :idInscripcion")
    fun getInscripcionById(idInscripcion: Int) : Inscripcion

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInscripcion(inscripcion: Inscripcion)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInscripciones(inscripcion: Array<Inscripcion>)

    @Update
    fun updateInscripcion(inscripcion: Inscripcion)

    @Delete
    fun deleteInscripcion(inscripcion: Inscripcion)

    @Delete
    fun deleteInscripciones(inscripciones: Array<Inscripcion>)
}