package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.TorneoDao
import com.bluetooth.padeltournamets.model.entities.TorneoEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ITorneoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TorneoRepositoryImpl @Inject constructor(private val torneoDao:TorneoDao): ITorneoRepository {
    override fun getAllTorneos(): Flow<List<TorneoEntity>> {
        return torneoDao.getAllTorneos()
    }

    override fun getTorneoById(idTorneo: Int): Flow<TorneoEntity> {
       return torneoDao.getTorneoById(idTorneo)
    }

    override suspend fun insertTorneo(torneoEntity: TorneoEntity) {
        torneoDao.insertTorneo(torneoEntity)
    }

    override suspend fun insertTorneos(torneoEntities: List<TorneoEntity>) {
        torneoDao.insertTorneos(torneoEntities)
    }

    override suspend fun updateTorneo(torneoEntity: TorneoEntity) {
        torneoDao.updateTorneo(torneoEntity)
    }

    override suspend fun deleteTorneo(torneoEntity: TorneoEntity) {
        torneoDao.deleteTorneo(torneoEntity)
    }

    override suspend fun deleteTorneos(torneoEntities: List<TorneoEntity>) {
        torneoDao.deleteTorneos(torneoEntities)
    }
}