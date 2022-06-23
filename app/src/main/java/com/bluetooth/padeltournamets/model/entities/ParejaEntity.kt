package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParejaEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val primerIntegrante: String,
    val segundoIntegrante: String
    )