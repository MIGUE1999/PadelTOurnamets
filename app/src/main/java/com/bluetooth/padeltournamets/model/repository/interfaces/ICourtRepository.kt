package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.entities.CourtEntity
import kotlinx.coroutines.flow.Flow

interface ICourtRepository {

    fun getAllCourts() : LiveData<List<CourtEntity>>

    fun getCourtById(idCourt: Int) : LiveData<CourtEntity>

    suspend fun insertCourt(courtEntity: CourtEntity)

    suspend fun updateCourt(courtEntity: CourtEntity)

    suspend fun deleteCourt(courtEntity: CourtEntity)

}