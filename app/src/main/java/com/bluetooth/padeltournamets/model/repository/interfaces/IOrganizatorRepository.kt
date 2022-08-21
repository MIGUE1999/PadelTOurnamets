package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity

interface IOrganizatorRepository {

    fun getAllOrganizators() : LiveData<List<OrganizatorEntity>>

    fun getOrganizatorById(idOrganizador: Int) : LiveData<OrganizatorEntity>

    suspend fun insertOrganizator(organizadorModel: OrganizatorEntity)

    suspend fun updateOrganizator(organizadorModel: OrganizatorEntity)

    suspend fun deleteOrganizator(organizadorModel: OrganizatorEntity)

}