package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.OrganizadorDao
import com.bluetooth.padeltournamets.model.entities.OrganizadorEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IOrganizadorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrganizadorRepositoryImpl @Inject constructor(private val organizadorDao : OrganizadorDao): IOrganizadorRepository {
    override fun getAllOrganizadores(): Flow<List<OrganizadorEntity>> {
        return organizadorDao.getAllOrganizadores()
    }

    override fun getOrganizadorById(idOrganizador: Int): Flow<OrganizadorEntity> {
        return organizadorDao.getOrganizadorById(idOrganizador)
    }

    override suspend fun insertOrganizador(organizadorModel: OrganizadorEntity) {
        organizadorDao.insertOrganizador(organizadorModel)
    }

    override suspend fun insertOrganizadores(organizadores: List<OrganizadorEntity>) {
        organizadorDao.insertOrganizadores(organizadores)
    }

    override suspend fun updateOrganizador(organizadorModel: OrganizadorEntity) {
        organizadorDao.updateOrganizador(organizadorModel)
    }

    override suspend fun deleteOrganizador(organizadorModel: OrganizadorEntity) {
        organizadorDao.deleteOrganizador(organizadorModel)
    }

    override suspend fun deleteOrganizadores(organizadores: List<OrganizadorEntity>) {
        organizadorDao.deleteOrganizadores(organizadores)
    }
}