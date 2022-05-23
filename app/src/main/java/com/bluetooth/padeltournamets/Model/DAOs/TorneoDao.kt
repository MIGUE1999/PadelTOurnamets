package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Torneo

@Dao
interface TorneoDao {

    @Query("SELECT * FROM Torneo")
    fun getAllTorneos() : Array<Torneo>

    @Query("SELECT * FROM Torneo WHERE id = :idTorneo")
    fun getTorneoById(idTorneo: Int) : Torneo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTorneo(torneo: Torneo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTorneos(torneos: Array<Torneo>)

    @Update
    fun updateTorneo(torneo: Torneo)

    @Delete
    fun deleteTorneo(torneo: Torneo)

    @Delete
    fun deleteTorneos(torneos: Array<Torneo>)
}