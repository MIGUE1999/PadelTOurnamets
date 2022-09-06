package com.bluetooth.padeltournamets.model.repository.implementation

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.dao.TournamentDao
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ITournamentRepository
import javax.inject.Inject

class TournamentRepositoryImpl @Inject constructor(private val tournamentDao:TournamentDao): ITournamentRepository {

    override fun getAllTorneos() = tournamentDao.getAll()

    override fun getTorneoById(idTorneo: Int): LiveData<TournamentEntity> {
       return tournamentDao.getById(idTorneo)
    }

    override suspend fun insertTorneo(tournamentEntity: TournamentEntity) {
        tournamentDao.insertTournament(tournamentEntity)
    }

    override suspend fun insertTorneos(tournamentEntities: List<TournamentEntity>) {
        tournamentDao.insertTournaments(tournamentEntities)
    }

    override suspend fun updateTorneo(tournamentEntity: TournamentEntity) {
        tournamentDao.updateTournament(tournamentEntity)
    }

    override suspend fun deleteTorneo(tournamentEntity: TournamentEntity) {
        tournamentDao.deleteTournament(tournamentEntity)
    }

    override suspend fun deleteTorneos(tournamentEntities: List<TournamentEntity>) {
        tournamentDao.deleteTournaments(tournamentEntities)
    }

    override fun getTournamentsByOrgId(idOrg : Int): LiveData<List<TournamentEntity>> {
        return tournamentDao.getTournamentsByOrgId(idOrg)
    }
}