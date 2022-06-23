package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.ReservaDao
import com.bluetooth.padeltournamets.model.entities.ReservaEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IReservaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReservaRepositoryImpl @Inject constructor(private val reservaDao : ReservaDao) : IReservaRepository  {
    override fun getAllReserva(): Flow<List<ReservaEntity>> {
        return reservaDao.getAllReserva()
    }

    override fun getReservaById(idReserva: Int): Flow<ReservaEntity> {
        return reservaDao.getReservaById(idReserva)
    }

    override suspend fun insertReserva(reservaEntity: ReservaEntity) {
        reservaDao.insertReserva(reservaEntity)
    }

    override suspend fun insertReservas(reservaEntities: List<ReservaEntity>) {
        reservaDao.insertReservas(reservaEntities)
    }

    override suspend fun updateReserva(reservaEntity: ReservaEntity) {
        reservaDao.updateReserva(reservaEntity)
    }

    override suspend fun deleteReserva(reservaEntity: ReservaEntity) {
        reservaDao.deleteReserva(reservaEntity)
    }

    override suspend fun deletereservas(reservaEntities: List<ReservaEntity>) {
        reservaDao.deletereservas(reservaEntities)
    }
}