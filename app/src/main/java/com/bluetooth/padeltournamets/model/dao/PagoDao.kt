package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.PagoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PagoDao {
    @Query("SELECT * FROM PagoEntity")
    fun getAllParejas() : Flow<List<PagoEntity>>

    @Query("SELECT * FROM PagoEntity WHERE id = :idPago")
    fun getPagoById(idPago: Int) : Flow<PagoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPago(pagoEntity: PagoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPagos(pagoEntities: List<PagoEntity>)

    @Update
    suspend fun updatePago(pagoEntity: PagoEntity)

    @Delete
    suspend fun deletePago(pagoEntity: PagoEntity)

    @Delete
    suspend fun deletePagos(pagoEntities: List<PagoEntity>)
}