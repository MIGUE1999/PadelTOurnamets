package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.EnfrentamientoDao
import com.bluetooth.padeltournamets.model.entities.EnfrentamientoEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IEnfrentamientoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EnfrentamientoRepositoryImpl @Inject constructor(private val enfrentamientoDao: EnfrentamientoDao): IEnfrentamientoRepository {
    override fun getAllEnfrentamiento(): Flow<List<EnfrentamientoEntity>> {
        return enfrentamientoDao.getAllEnfrentamiento()
    }

    override fun getEnfrentamientoById(idEnfrentamiento: Int): Flow<EnfrentamientoEntity> {
        return enfrentamientoDao.getEnfrentamientoById(idEnfrentamiento)
    }

    override suspend fun insertEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity) {
        enfrentamientoDao.insertEnfrentamiento(enfrentamientoEntity)
    }

    override suspend fun insertEnfrentamientos(enfrentamientoEntity: List<EnfrentamientoEntity>) {
        enfrentamientoDao.insertEnfrentamientos(enfrentamientoEntity)
    }

    override suspend fun updateEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity) {
        enfrentamientoDao.updateEnfrentamiento(enfrentamientoEntity)
    }

    override suspend fun deleteEnfrentamiento(enfrentamientoEntity: EnfrentamientoEntity) {
        enfrentamientoDao.deleteEnfrentamiento(enfrentamientoEntity)
    }

    override suspend fun deleteEnfrentamientos(enfrentamientoEntities: List<EnfrentamientoEntity>) {
        enfrentamientoDao.deleteEnfrentamientos(enfrentamientoEntities)
    }
}