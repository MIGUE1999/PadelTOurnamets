package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.UsuarioDao
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IUsuarioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(private val usuarioDao : UsuarioDao) : IUsuarioRepository {

    override fun getUsuario(usrId: Int): Flow<UsuarioEntity> {
        return usuarioDao.getUsuarioById(usrId)
    }
    override fun getAllUsuarios(): Flow<List<UsuarioEntity>> {
        return usuarioDao.getAllUsuarios()
    }
    override suspend fun insertUsuario(usr: UsuarioEntity) {
        return usuarioDao.insertUsuario(usr)
    }
    override suspend fun insertUsuarios(usr: List<UsuarioEntity>) {
        return usuarioDao.insertUsuarios(usr)
    }
    override suspend fun deleteUsuario(usr: UsuarioEntity) {
        return usuarioDao.deleteUsuario(usr)
    }
    override suspend fun deleteUsuarios(usrs: List<UsuarioEntity>) {
        return usuarioDao.deleteUsuarios(usrs)
    }
    override suspend fun modifyUsuario(usr: UsuarioEntity) {
        return usuarioDao.updateUsuario(usr)
    }


}