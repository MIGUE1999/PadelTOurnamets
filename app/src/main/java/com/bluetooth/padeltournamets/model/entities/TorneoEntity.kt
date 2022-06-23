package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TorneoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val nombre: String,
    val cartel: String?,
    val premio: String,
    val precioInscripcion: String,
    val categoria: String
    //idReserva
)