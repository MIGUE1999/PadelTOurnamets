package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Reserva(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    //val idPista: Int
    val fechaInicio : String,
    val fechaFin : String
    )
