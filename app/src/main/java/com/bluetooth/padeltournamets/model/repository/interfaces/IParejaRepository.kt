package com.bluetooth.padeltournamets.model.repository.interfaces

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.ParejaEntity
import kotlinx.coroutines.flow.Flow

interface IParejaRepository {

    fun getAllParejas() : Flow<List<ParejaEntity>>

    fun getParejaById(idPareja: Int) : Flow<ParejaEntity>

    suspend fun insertPareja(parejaEntity: ParejaEntity)

    suspend fun insertParejas(parejaEntity: List<ParejaEntity>)

    suspend fun updatePareja(parejaEntity: ParejaEntity)

    suspend fun deletePareja(parejaEntity: ParejaEntity)

    suspend fun deleteParejas(parejaEntities: List<ParejaEntity>)
}