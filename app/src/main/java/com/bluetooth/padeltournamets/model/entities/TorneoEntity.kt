package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TorneoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val nombre: String,
    val categoria: String,
    val precioInscripcion: String,
    val fechaInicio: String,
    val fechaFin: String,
    val fechaLimiteInscripcion : String,
    val premio: String,
    val cartel: String?,


    //idReserva
)