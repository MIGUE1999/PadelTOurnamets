package com.bluetooth.padeltournamets.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bluetooth.padeltournamets.model.entities.UserEntity


@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers() : LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :idUsuario")
    fun getUserById(idUsuario: Int) : LiveData<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

}