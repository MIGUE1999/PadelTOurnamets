package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Enfrentamiento
import com.bluetooth.padeltournamets.Model.Entities.Pareja

@Dao
interface EnfrentamientoDao {
    @Query("SELECT * FROM Enfrentamiento")
    fun getAllEnfrentamiento() : Array<Enfrentamiento>

    @Query("SELECT * FROM Enfrentamiento WHERE id = :idEnfrentamiento")
    fun getEnfrentamientoById(idEnfrentamiento: Int) : Enfrentamiento

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEnfrentamiento(enfrentamiento: Enfrentamiento)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEnfrentamientos(enfrentamiento: Array<Enfrentamiento>)

    @Update
    fun updateEnfrentamiento(enfrentamiento: Enfrentamiento)

    @Delete
    fun deleteEnfrentamiento(enfrentamiento: Enfrentamiento)

    @Delete
    fun deleteEnfrentamientos(enfrentamientos: Array<Enfrentamiento>)
}