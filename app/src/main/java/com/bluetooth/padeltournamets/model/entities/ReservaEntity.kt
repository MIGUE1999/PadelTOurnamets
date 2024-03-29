package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReservaEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    //val idPista: Int
    val fechaInicio : String,
    val fechaFin : String
    )
