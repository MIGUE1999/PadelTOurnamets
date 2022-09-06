package com.bluetooth.padeltournamets.model.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.relations.OrganizatorWithTournaments
import kotlinx.coroutines.flow.Flow

@Dao
interface OrganizatorDao {
    @Query("SELECT * FROM organizador")
    fun getAllOrganizators() : LiveData<List<OrganizatorEntity>>

    @Query("SELECT * FROM organizador WHERE id = :idOrganizador")
    fun getOrganizatorById(idOrganizador: Int) : LiveData<OrganizatorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrganizator(organizadorModel: OrganizatorEntity)

    @Update
    suspend fun updateOrganizator(organizadorModel: OrganizatorEntity)

    @Delete
    suspend fun deleteOrganizator(organizadorModel: OrganizatorEntity)

    @Query("SELECT * FROM organizador WHERE userId = :idUser")
    fun getOrganizatorByUserId(idUser: Int) : OrganizatorEntity

    /*
    @Transaction
    @Query("SELECT * FROM organizador INNER JOIN torneo ON organizador.id = torneo.idOrganizator")
    fun getOrganizatorWithTournaments() : LiveData<List<OrganizatorWithTournaments>>

*/

    @Transaction
    @Query("SELECT * FROM organizador " +
            "INNER JOIN torneo ON organizador.id = torneo.idOrganizator " +
            "WHERE organizador.id = :idOr")
    fun getOrganizatorWithTournaments(idOr : Int) : List<OrganizatorWithTournaments>

    @Transaction
    @Query("SELECT * FROM organizador, torneo WHERE torneo.categoria = :categoria")
    fun getTournamentsByCategory(categoria: String) : LiveData<List<OrganizatorWithTournaments>>


    /*
    @Transaction
    @Query("SELECT * FROM organizador WHERE id = :idOrganizator")
    suspend fun getorganizatorWithTournaments(idOrganizator: Int) : List<OrganizatorWithTournaments>
*/
}
