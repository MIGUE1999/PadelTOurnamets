package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.TorneoOrganizado

@Dao
interface TorneoOrganizadoDao {
    @Query("SELECT * FROM TorneoOrganizado")
    fun getAllTorneoOrganizado() : Array<TorneoOrganizado>

    @Query("SELECT * FROM TorneoOrganizado WHERE id = :idTorneoOrganizado")
    fun getTorneoOrganizadoById(idTorneoOrganizado: Int) : TorneoOrganizado

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTorneoOrganizado(torneoOrganizado: TorneoOrganizado)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTorneoOrganizado(torneosOrganizados: Array<TorneoOrganizado>)

    @Update
    fun updateTorneoOrganizado(torneoOrganizado: TorneoOrganizado)

    @Delete
    fun deleteTorneoOrganizado(torneoOrganizado: TorneoOrganizado)

    @Delete
    fun deleteTorneosOrganizados(torneosOrganizados: Array<TorneoOrganizado>)
}