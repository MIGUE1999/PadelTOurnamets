package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InscripcionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    //val idPareja: Int,
    //idPago
    //idTorneoInscrito
    //val nombreUsuarioPagador
)
