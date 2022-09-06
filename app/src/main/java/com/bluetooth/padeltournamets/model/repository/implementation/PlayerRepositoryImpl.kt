package com.bluetooth.padeltournamets.model.repository.implementation

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.dao.PlayerDao
import com.bluetooth.padeltournamets.model.entities.PlayerEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IPlayerRepository
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(private val playerDao : PlayerDao) : IPlayerRepository {
    override fun getAllPlayers(): LiveData<List<PlayerEntity>> {
        return playerDao.getAllPlayers()
    }

    override fun getPlayerById(idJugador: Int): LiveData<PlayerEntity> {
        return playerDao.getPlayerById(idJugador)
    }

    override suspend fun insertPlayer(playerModel: PlayerEntity) {
        playerDao.insertPlayer(playerModel)
    }


    override suspend fun updatePlayer(playerModel: PlayerEntity) {
        playerDao.updatePlayer(playerModel)
    }

    override suspend fun deletePlayer(playerModel: PlayerEntity) {
        playerDao.deleteJugador(playerModel)
    }

    override fun getPlayerByUserId(userId: Int): PlayerEntity {
        return playerDao.getPlayerByUserId(userId)
    }

}