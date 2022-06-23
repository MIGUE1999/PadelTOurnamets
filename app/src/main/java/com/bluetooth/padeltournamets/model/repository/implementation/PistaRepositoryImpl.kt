package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.PistaDao
import com.bluetooth.padeltournamets.model.entities.PistaEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IPistaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PistaRepositoryImpl @Inject constructor(private val pistaDao : PistaDao): IPistaRepository {
    override fun getAllPistas(): Flow<List<PistaEntity>> {
        return pistaDao.getAllPistas()
    }

    override fun getPistaById(idPista: Int): Flow<PistaEntity> {
        return pistaDao.getPistaById(idPista)
    }

    override suspend fun insertPista(pistaEntity: PistaEntity) {
        pistaDao.insertPista(pistaEntity)
    }

    override suspend fun insertPistas(pistaEntities: List<PistaEntity>) {
        pistaDao.insertPistas(pistaEntities)
    }

    override suspend fun updatePista(pistaEntity: PistaEntity) {
        pistaDao.updatePista(pistaEntity)
    }

    override suspend fun deletePista(pistaEntity: PistaEntity) {
        pistaDao.deletePista(pistaEntity)
    }

    override suspend fun deletePistas(pistaEntities: List<PistaEntity>) {
        pistaDao.deletePistas(pistaEntities)
    }
}