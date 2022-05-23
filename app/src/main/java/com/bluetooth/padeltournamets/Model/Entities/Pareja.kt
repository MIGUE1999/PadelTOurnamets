package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pareja (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val primerIntegrante: String,
    val segundoIntegrante: String
    )