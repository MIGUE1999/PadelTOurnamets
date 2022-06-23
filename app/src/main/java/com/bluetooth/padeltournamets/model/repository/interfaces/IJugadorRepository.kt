package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.JugadorEntity
import kotlinx.coroutines.flow.Flow

interface IJugadorRepository {

    fun getAllJugadores() : Flow<List<JugadorEntity>>

    fun getJugadorById(idJugador : Int) : Flow<JugadorEntity>

    suspend fun insertJugador(jugadorModel: JugadorEntity)

    suspend fun insertJugadores(jugadorModel: List<JugadorEntity>)

    suspend fun updateJugador(jugadorModel: JugadorEntity)

    suspend fun deleteJugador(jugadorModel: JugadorEntity)

    suspend fun deleteJugadores(jugadores: List<JugadorEntity>)
}