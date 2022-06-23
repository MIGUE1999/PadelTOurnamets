package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.TorneoOrganizadoDao
import com.bluetooth.padeltournamets.model.dao.UsuarioDao
import com.bluetooth.padeltournamets.model.entities.TorneoOrganizadoEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ITorneoOrganizadoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TorneoOrganizadoRepositoryImpl @Inject constructor(private val torneoOrganizadoDao : TorneoOrganizadoDao)  : ITorneoOrganizadoRepository {
    override fun getAllTorneoOrganizado(): Flow<List<TorneoOrganizadoEntity>> {
        return torneoOrganizadoDao.getAllTorneoOrganizado()
    }

    override fun getTorneoOrganizadoById(idTorneoOrganizado: Int): Flow<TorneoOrganizadoEntity> {
        return torneoOrganizadoDao.getTorneoOrganizadoById(idTorneoOrganizado)
    }

    override suspend fun insertTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity) {
       torneoOrganizadoDao.insertTorneoOrganizado(torneoOrganizadoEntity)
    }

    override suspend fun insertTorneoOrganizado(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>) {
        torneoOrganizadoDao.insertTorneoOrganizado(torneosOrganizadoEntities)

    }

    override suspend fun updateTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity) {
        torneoOrganizadoDao.updateTorneoOrganizado(torneoOrganizadoEntity)
    }

    override suspend fun deleteTorneoOrganizado(torneoOrganizadoEntity: TorneoOrganizadoEntity) {
        torneoOrganizadoDao.deleteTorneoOrganizado(torneoOrganizadoEntity)
    }

    override suspend fun deleteTorneosOrganizados(torneosOrganizadoEntities: List<TorneoOrganizadoEntity>) {
        torneoOrganizadoDao.deleteTorneosOrganizados(torneosOrganizadoEntities)
    }

}