package com.bluetooth.padeltournamets.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.PlayerEntity

@Dao
interface PlayerDao {

    @Query("SELECT * FROM jugador")
    fun getAllPlayers() : LiveData<List<PlayerEntity>>

    @Query("SELECT * FROM jugador WHERE id = :idJugador")
    fun getPlayerById(idJugador : Int) : LiveData<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Delete
    suspend fun deleteJugador(player: PlayerEntity)


}