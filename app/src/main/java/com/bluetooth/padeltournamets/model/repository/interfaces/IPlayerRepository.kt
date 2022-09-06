package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.PlayerEntity

interface IPlayerRepository {

    fun getAllPlayers() : LiveData<List<PlayerEntity>>

    fun getPlayerById(idPlayer : Int) : LiveData<PlayerEntity>

    suspend fun insertPlayer(playerModel: PlayerEntity)

    suspend fun updatePlayer(playerModel: PlayerEntity)

    suspend fun deletePlayer(playerModel: PlayerEntity)

    fun getPlayerByUserId(userId : Int) : PlayerEntity


}