package com.bluetooth.padeltournamets.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TournamentDao  {

    @Query("SELECT * FROM torneo")
    fun getAll(): LiveData<List<TournamentEntity>>

    @Query("SELECT * FROM torneo WHERE id = :idTorneo")
    fun getById(idTorneo: Int) : LiveData<TournamentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTournament(tournamentEntity: TournamentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTournaments(tournamentEntities: List<TournamentEntity>)

    @Update
    suspend fun updateTournament(tournamentEntity: TournamentEntity)

    @Delete
    suspend fun deleteTournament(tournamentEntity: TournamentEntity)

    @Delete
    suspend fun deleteTournaments(tournamentEntities: List<TournamentEntity>)

    @Query("SELECT * FROM torneo WHERE idOrganizator = :idOrg")
    fun getTournamentsByOrgId(idOrg: Int) : LiveData<List<TournamentEntity>>

}