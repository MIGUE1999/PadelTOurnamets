package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Pago

@Dao
interface PagoDao {
    @Query("SELECT * FROM Pago")
    fun getAllParejas() : Array<Pago>

    @Query("SELECT * FROM Pago WHERE id = :idPago")
    fun getPagoById(idPago: Int) : Pago

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPago(pago: Pago)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPagos(pagos: Array<Pago>)

    @Update
    fun updatePago(pago: Pago)

    @Delete
    fun deletePago(pago: Pago)

    @Delete
    fun deletePagos(pagos: Array<Pago>)
}