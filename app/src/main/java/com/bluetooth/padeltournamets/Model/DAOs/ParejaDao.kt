package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Pareja

@Dao
interface ParejaDao {
    @Query("SELECT * FROM Pareja")
    fun getAllParejas() : Array<Pareja>

    @Query("SELECT * FROM Pareja WHERE id = :idPareja")
    fun getParejaById(idPareja: Int) : Pareja

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPareja(pareja: Pareja)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParejas(pareja: Array<Pareja>)

    @Update
    fun updatePareja(pareja: Pareja)

    @Delete
    fun deletePareja(pareja: Pareja)

    @Delete
    fun deleteParejas(parejas: Array<Pareja>)
}