package com.bluetooth.padeltournamets.model.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "organizador",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        childColumns = ["userId"],
        parentColumns = ["id"]
    )])data class OrganizatorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var cif : String,
    var clubName : String,
    var bankAccount : String,
    var userId : Int
    //torneosOrganizados
)