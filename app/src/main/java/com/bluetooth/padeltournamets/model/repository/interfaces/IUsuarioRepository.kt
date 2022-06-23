package com.bluetooth.padeltournamets.model.repository.interfaces

import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import kotlinx.coroutines.flow.Flow

interface IUsuarioRepository {

    fun getUsuario(usrId: Int): Flow<UsuarioEntity>

    fun getAllUsuarios(): Flow<List<UsuarioEntity>>

    suspend fun insertUsuario(usr: UsuarioEntity)

    suspend fun insertUsuarios(usr: List<UsuarioEntity>)

    suspend fun deleteUsuario(usr: UsuarioEntity)

    suspend fun deleteUsuarios(usr: List<UsuarioEntity>)

    suspend fun modifyUsuario(usr: UsuarioEntity)
}