package com.bluetooth.padeltournamets.model.dao

import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.ParejaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ParejaDao {
    @Query("SELECT * FROM ParejaEntity")
    fun getAllParejas() : Flow<List<ParejaEntity>>

    @Query("SELECT * FROM ParejaEntity WHERE id = :idPareja")
    fun getParejaById(idPareja: Int) : Flow<ParejaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPareja(parejaEntity: ParejaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParejas(parejaEntity: List<ParejaEntity>)

    @Update
    suspend fun updatePareja(parejaEntity: ParejaEntity)

    @Delete
    suspend fun deletePareja(parejaEntity: ParejaEntity)

    @Delete
    suspend fun deleteParejas(parejaEntities: List<ParejaEntity>)
}