package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.ParejaDao
import com.bluetooth.padeltournamets.model.entities.ParejaEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IParejaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ParejaRepositoryImpl @Inject constructor(private val parejaDao: ParejaDao): IParejaRepository {
    override fun getAllParejas(): Flow<List<ParejaEntity>> {
        return parejaDao.getAllParejas()
    }

    override fun getParejaById(idPareja: Int): Flow<ParejaEntity> {
        return parejaDao.getParejaById(idPareja)
    }

    override suspend fun insertPareja(parejaEntity: ParejaEntity) {
        parejaDao.insertPareja(parejaEntity)
    }

    override suspend fun insertParejas(parejaEntity: List<ParejaEntity>) {
        parejaDao.insertParejas(parejaEntity)
    }

    override suspend fun updatePareja(parejaEntity: ParejaEntity) {
        parejaDao.updatePareja(parejaEntity)
    }

    override suspend fun deletePareja(parejaEntity: ParejaEntity) {
        parejaDao.deletePareja(parejaEntity)
    }

    override suspend fun deleteParejas(parejaEntities: List<ParejaEntity>) {
        parejaDao.deleteParejas(parejaEntities)
    }
}