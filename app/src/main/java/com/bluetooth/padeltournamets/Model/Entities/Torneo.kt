package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity
data class Torneo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val cartel: String?,
    val premio: String,
    val precioInscripcion: String,
    val categoria: String
    //idReserva
)