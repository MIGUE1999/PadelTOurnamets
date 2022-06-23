package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EnfrentamientoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    //idParejaLocal
    //idParejaVisitante
    val fecha: String
    //val parejaGanadora : Pareja?
)