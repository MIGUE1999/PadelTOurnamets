package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity
data class Enfrentamiento (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //idParejaLocal
    //idParejaVisitante
    val fecha: String
    //val parejaGanadora : Pareja?
)