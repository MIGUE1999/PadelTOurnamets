package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.JugadorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JugadorDao {

    @Query("SELECT * FROM JugadorEntity")
    fun getAllJugadores() : Flow<List<JugadorEntity>>

    @Query("SELECT * FROM JugadorEntity WHERE id = :idJugador")
    fun getJugadorById(idJugador : Int) : Flow<JugadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJugador(jugadorModel: JugadorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJugadores(jugadorModel: List<JugadorEntity>)

    @Update
    suspend fun updateJugador(jugadorModel: JugadorEntity)

    @Delete
    suspend fun deleteJugador(jugadorModel: JugadorEntity)

    @Delete
    suspend fun deleteJugadores(jugadores: List<JugadorEntity>)
}