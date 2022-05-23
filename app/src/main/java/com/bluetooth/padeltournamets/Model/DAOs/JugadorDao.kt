package com.bluetooth.padeltournamets.Model.DAOs

import androidx.room.*
import com.bluetooth.padeltournamets.Model.Entities.Jugador
import com.bluetooth.padeltournamets.Model.Entities.Usuario
@Dao
interface JugadorDao {

    @Query("SELECT * FROM Jugador")
    fun getAllJugadores() : Array<Jugador>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJugador(jugador: Jugador)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJugadores(jugador: Array<Jugador>)

    @Update
    fun updateJugador(jugador: Jugador)

    @Delete
    fun deleteJugador(jugador: Jugador)

    @Delete
    fun deleteJugadores(jugadores: Array<Jugador>)
}