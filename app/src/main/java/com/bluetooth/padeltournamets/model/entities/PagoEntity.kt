package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class PagoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val cantidad: String
)
