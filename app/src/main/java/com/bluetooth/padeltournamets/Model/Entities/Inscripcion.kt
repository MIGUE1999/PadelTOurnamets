package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Inscripcion(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //val idPareja: Int,
    //idPago
    //idTorneoInscrito
    //val nombreUsuarioPagador
)
