package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UsuarioDao {

    @Query("SELECT * FROM UsuarioEntity")
    fun getAllUsuarios() : Flow<List<UsuarioEntity>>

    @Query("SELECT * FROM UsuarioEntity WHERE id = :idUsuario")
    fun getUsuarioById(idUsuario: Int) : Flow<UsuarioEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsuario(usuarioEntity: UsuarioEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsuarios(usuarioEntities: List<UsuarioEntity>)

    @Update
    suspend fun updateUsuario(usuarioEntity: UsuarioEntity)

    @Delete
    suspend fun deleteUsuario(usuarioEntity: UsuarioEntity)

    @Delete
    suspend fun deleteUsuarios(usuarioEntities: List<UsuarioEntity>)

}