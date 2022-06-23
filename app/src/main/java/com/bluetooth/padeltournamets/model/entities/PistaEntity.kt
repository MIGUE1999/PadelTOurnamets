package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PistaEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val ubicacion: String,
    val numeroPista: String
)