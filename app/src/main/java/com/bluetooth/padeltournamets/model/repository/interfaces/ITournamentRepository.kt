package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.entities.TournamentEntity

interface ITournamentRepository {
    fun getAllTorneos() : LiveData<List<TournamentEntity>>

    fun getTorneoById(idTorneo: Int) : LiveData<TournamentEntity>

    suspend fun insertTorneo(tournamentEntity: TournamentEntity)

    suspend fun insertTorneos(tournamentEntities: List<TournamentEntity>)

    suspend fun updateTorneo(tournamentEntity: TournamentEntity)

    suspend fun deleteTorneo(tournamentEntity: TournamentEntity)

    suspend fun deleteTorneos(tournamentEntities: List<TournamentEntity>)
}