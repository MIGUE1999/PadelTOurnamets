package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Torneo
import com.bluetooth.padeltournamets.Model.Entities.Usuario

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM Usuario")
    fun getAllUsuarios() : Array<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :idUsuario")
    fun getUsuarioById(idUsuario: Int) : Usuario

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(usuario: Usuario)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuarios(usuarios: Array<Usuario>)

    @Update
    fun updateUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuarios(usuarios: Array<Usuario>)

}