package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TorneoOrganizadoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    //val idEnfrentamientos : Enfrentamiento?
    //val idInscripciones : Inscripcion?
    val idGanador: Int

)
