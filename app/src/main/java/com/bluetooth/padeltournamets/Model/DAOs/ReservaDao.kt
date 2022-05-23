package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Reserva
import com.bluetooth.padeltournamets.Model.Entities.TorneoOrganizado

@Dao
interface ReservaDao {
    @Query("SELECT * FROM Reserva")
    fun getAllReserva() : Array<Reserva>

    @Query("SELECT * FROM Reserva WHERE id = :idReserva")
    fun getReservaById(idReserva: Int) : Reserva

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReserva(reserva: Reserva)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReserva(reservas: Array<Reserva>)

    @Update
    fun updateReserva(reserva: Reserva)

    @Delete
    fun deleteReserva(reserva: Reserva)

    @Delete
    fun deletereservas(reservas: Array<Reserva>)
}