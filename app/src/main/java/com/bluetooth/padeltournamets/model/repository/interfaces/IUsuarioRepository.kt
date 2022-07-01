package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import kotlinx.coroutines.flow.Flow

interface IUsuarioRepository {

    suspend fun getUsuario(usrId: Int): LiveData<UsuarioEntity>

    fun getAllUsuarios(): LiveData<List<UsuarioEntity>>

    suspend fun insertUsuario(usr: UsuarioEntity)

    suspend fun insertUsuarios(usr: List<UsuarioEntity>)

    suspend fun deleteUsuario(usr: UsuarioEntity)

    suspend fun deleteUsuarios(usr: List<UsuarioEntity>)

    suspend fun modifyUsuario(usr: UsuarioEntity)
}