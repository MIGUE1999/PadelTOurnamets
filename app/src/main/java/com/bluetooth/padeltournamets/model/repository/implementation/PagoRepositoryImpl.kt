package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.PagoDao
import com.bluetooth.padeltournamets.model.entities.PagoEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IPagoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagoRepositoryImpl @Inject constructor(private val pagoDao: PagoDao): IPagoRepository {
    override fun getAllParejas(): Flow<List<PagoEntity>> {
        return pagoDao.getAllParejas()
    }

    override fun getPagoById(idPago: Int): Flow<PagoEntity> {
        return pagoDao.getPagoById(idPago)
    }

    override suspend fun insertPago(pagoEntity: PagoEntity) {
        pagoDao.insertPago(pagoEntity)
    }

    override suspend fun insertPagos(pagoEntities: List<PagoEntity>) {
        pagoDao.insertPagos(pagoEntities)
    }

    override suspend fun updatePago(pagoEntity: PagoEntity) {
        pagoDao.updatePago(pagoEntity)
    }

    override suspend fun deletePago(pagoEntity: PagoEntity) {
        pagoDao.deletePago(pagoEntity)
    }

    override suspend fun deletePagos(pagoEntities: List<PagoEntity>) {
        pagoDao.deletePagos(pagoEntities)
    }
}