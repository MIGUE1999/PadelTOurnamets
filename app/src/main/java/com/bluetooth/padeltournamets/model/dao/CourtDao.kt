package com.bluetooth.padeltournamets.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.CourtEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourtDao
{
    @Query("SELECT * FROM pista")
    fun getAllCourts() : LiveData<List<CourtEntity>>

    @Query("SELECT * FROM pista WHERE id = :idCourt")
    fun getCourtById(idCourt: Int) : LiveData<CourtEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourt(courtEntity: CourtEntity)

    @Update
    suspend fun updateCourt(courtEntity: CourtEntity)

    @Delete
    suspend fun deleteCourt(courtEntity: CourtEntity)
}