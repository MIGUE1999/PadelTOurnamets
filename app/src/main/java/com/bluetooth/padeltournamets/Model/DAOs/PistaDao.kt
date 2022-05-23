package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Pista
import com.bluetooth.padeltournamets.Model.Entities.Usuario

@Dao
interface PistaDao {

    @Query("SELECT * FROM Pista")
    fun getAllPistas() : Array<Pista>

    @Query("SELECT * FROM Pista WHERE id = :idPista")
    fun getPistaById(idPista: Int) : Pista

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPista(pista: Pista)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPistas(pistas: Array<Pista>)

    @Update
    fun updatePista(pista: Pista)

    @Delete
    fun deletePista(pista: Pista)

    @Delete
    fun deletePistas(pistas: Array<Pista>)
}