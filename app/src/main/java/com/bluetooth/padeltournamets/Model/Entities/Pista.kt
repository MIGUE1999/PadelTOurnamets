package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity
data class Pista (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ubicacion: String,
    val numeroPista: String
)