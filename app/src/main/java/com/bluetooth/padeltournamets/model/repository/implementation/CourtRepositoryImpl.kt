package com.bluetooth.padeltournamets.model.repository.implementation

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.dao.CourtDao
import com.bluetooth.padeltournamets.model.entities.CourtEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ICourtRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CourtRepositoryImpl @Inject constructor(private val courtDao : CourtDao): ICourtRepository {
    override fun getAllCourts(): LiveData<List<CourtEntity>> {
        return courtDao.getAllCourts()
    }

    override fun getCourtById(idCourt: Int): LiveData<CourtEntity> {
        return courtDao.getCourtById(idCourt)
    }

    override suspend fun insertCourt(courtEntity: CourtEntity) {
        courtDao.insertCourt(courtEntity)
    }

    override suspend fun updateCourt(courtEntity: CourtEntity) {
        courtDao.updateCourt(courtEntity)
    }

    override suspend fun deleteCourt(courtEntity: CourtEntity) {
        courtDao.deleteCourt(courtEntity)
    }
}