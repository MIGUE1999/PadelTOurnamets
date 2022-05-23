package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TorneoOrganizado(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //val idEnfrentamientos : Enfrentamiento?
    //val idInscripciones : Inscripcion?
    val idGanador: Int

)
