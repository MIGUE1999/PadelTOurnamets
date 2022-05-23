package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Pago(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cantidad: String
)
