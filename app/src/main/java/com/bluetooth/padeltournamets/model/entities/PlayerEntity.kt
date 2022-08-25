package com.bluetooth.padeltournamets.model.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(tableName = "jugador",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        childColumns = ["userId"],
        parentColumns = ["id"]
    )])
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nickname : String,
    var userId : Int
    //torneosGanados
)