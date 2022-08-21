package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pista")
data class CourtEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val ubicacion: String,
    val numeroPista: String
)