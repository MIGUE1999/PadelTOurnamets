package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Organizador
@Dao
interface OrganizadorDao {
    @Query("SELECT * FROM Organizador")
    fun getAllOrganizadores() : Array<Organizador>

    @Query("SELECT * FROM Organizador WHERE id = :idOrganizador")
    fun getOrganizadorById(idOrganizador: Int) : Organizador

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrganizador(organizador: Organizador)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrganizadores(organizadores: Array<Organizador>)

    @Update
    fun updateOrganizador(organizador: Organizador)

    @Delete
    fun deleteOrganizador(organizador: Organizador)

    @Delete
    fun deleteOrganizadores(organizadores: Array<Organizador>)
}