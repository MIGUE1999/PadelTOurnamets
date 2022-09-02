package com.bluetooth.padeltournamets.model.repository.implementation

import androidx.lifecycle.LiveData
import com.bluetooth.padeltournamets.model.dao.OrganizatorDao
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.relations.OrganizatorWithTournaments
import com.bluetooth.padeltournamets.model.repository.interfaces.IOrganizatorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrganizatorRepositoryImpl @Inject constructor(private val organizatorDao : OrganizatorDao): IOrganizatorRepository {
    override fun getAllOrganizators(): LiveData<List<OrganizatorEntity>> {
        return organizatorDao.getAllOrganizators()
    }

    override fun getOrganizatorById(idOrganizator: Int): LiveData<OrganizatorEntity> {
        return organizatorDao.getOrganizatorById(idOrganizator)
    }

    override suspend fun insertOrganizator(organizadorModel: OrganizatorEntity) {
        organizatorDao.insertOrganizator(organizadorModel)
    }

    override suspend fun updateOrganizator(organizator: OrganizatorEntity) {
        organizatorDao.updateOrganizator(organizator)
    }

    override suspend fun deleteOrganizator(organizator: OrganizatorEntity) {
        organizatorDao.deleteOrganizator(organizator)
    }

    override fun getOrganizatorWithTournaments(): LiveData<List<OrganizatorWithTournaments>> {
        return organizatorDao.getOrganizatorWithTournaments()
    }

    override fun getOrganizatorByUserId(userId: Int): OrganizatorEntity {
        return organizatorDao.getOrganizatorByUserId(userId)
    }


}