package com.bluetooth.padeltournamets.model.repository.implementation

import com.bluetooth.padeltournamets.model.dao.InscripcionDao
import com.bluetooth.padeltournamets.model.entities.InscripcionEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IInscripcionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InscripcionRepositoryImpl @Inject constructor(private val inscripcionDao: InscripcionDao): IInscripcionRepository {
    override fun getAllInscripcion(): Flow<List<InscripcionEntity>> {
        return inscripcionDao.getAllInscripcion()
    }

    override fun getInscripcionById(idInscripcion: Int): Flow<InscripcionEntity> {
        return inscripcionDao.getInscripcionById(idInscripcion)
    }

    override suspend fun insertInscripcion(inscripcionEntity: InscripcionEntity) {
        inscripcionDao.insertInscripcion(inscripcionEntity)
    }

    override suspend fun insertInscripciones(inscripcionEntity: List<InscripcionEntity>) {
        inscripcionDao.insertInscripciones(inscripcionEntity)
    }

    override suspend fun updateInscripcion(inscripcionEntity: InscripcionEntity) {
        inscripcionDao.updateInscripcion(inscripcionEntity)
    }

    override suspend fun deleteInscripcion(inscripcionEntity: InscripcionEntity) {
        inscripcionDao.deleteInscripcion(inscripcionEntity)
    }

    override suspend fun deleteInscripciones(inscripciones: List<InscripcionEntity>) {
        inscripcionDao.deleteInscripciones(inscripciones)
    }
}