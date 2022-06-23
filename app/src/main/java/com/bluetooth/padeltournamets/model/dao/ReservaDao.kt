package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.ReservaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservaDao {
    @Query("SELECT * FROM ReservaEntity")
    fun getAllReserva() : Flow<List<ReservaEntity>>

    @Query("SELECT * FROM ReservaEntity WHERE id = :idReserva")
    fun getReservaById(idReserva: Int) : Flow<ReservaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReserva(reservaEntity: ReservaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReservas(reservaEntities: List<ReservaEntity>)

    @Update
    suspend fun updateReserva(reservaEntity: ReservaEntity)

    @Delete
    suspend fun deleteReserva(reservaEntity: ReservaEntity)

    @Delete
    suspend fun deletereservas(reservaEntities: List<ReservaEntity>)
}