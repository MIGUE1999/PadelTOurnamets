package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.JugadorDao
import com.bluetooth.padeltournamets.model.entities.JugadorEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IJugadorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JugadorRepositoryImpl @Inject constructor(private val jugadorDao : JugadorDao) : IJugadorRepository {
    override fun getAllJugadores(): Flow<List<JugadorEntity>> {
        return jugadorDao.getAllJugadores()
    }

    override fun getJugadorById(idJugador: Int): Flow<JugadorEntity> {
        return jugadorDao.getJugadorById(idJugador)
    }

    override suspend fun insertJugador(jugadorModel: JugadorEntity) {
        jugadorDao.insertJugador(jugadorModel)
    }

    override suspend fun insertJugadores(jugadorModel: List<JugadorEntity>) {
        jugadorDao.insertJugadores(jugadorModel)
    }

    override suspend fun updateJugador(jugadorModel: JugadorEntity) {
        jugadorDao.updateJugador(jugadorModel)
    }

    override suspend fun deleteJugador(jugadorModel: JugadorEntity) {
        jugadorDao.deleteJugador(jugadorModel)
    }

    override suspend fun deleteJugadores(jugadores: List<JugadorEntity>) {
        jugadorDao.deleteJugadores(jugadores)
    }
}