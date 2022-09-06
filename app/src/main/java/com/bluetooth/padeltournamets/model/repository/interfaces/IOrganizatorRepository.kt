package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.relations.OrganizatorWithTournaments

interface IOrganizatorRepository {

    fun getAllOrganizators() : LiveData<List<OrganizatorEntity>>

    fun getOrganizatorById(idOrganizador: Int) : LiveData<OrganizatorEntity>

    suspend fun insertOrganizator(organizadorModel: OrganizatorEntity)

    suspend fun updateOrganizator(organizadorModel: OrganizatorEntity)

    suspend fun deleteOrganizator(organizadorModel: OrganizatorEntity)

    fun getOrganizatorWithTournaments(idOr : Int) : List<OrganizatorWithTournaments>

    fun getOrganizatorByUserId(userId : Int) : OrganizatorEntity



}