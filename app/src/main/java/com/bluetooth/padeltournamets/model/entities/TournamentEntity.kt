package com.bluetooth.padeltournamets.model.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "torneo")
data class TournamentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val categoria: String,
    @ColumnInfo(name = "precio_inscripcion")
    val precioInscripcion: String,
    @ColumnInfo(name = "fecha_inicio")
    val fechaInicio: String,
    @ColumnInfo(name = "fecha_fin")
    val fechaFin: String,
    @ColumnInfo(name = "fecha_limite_inscripcion")
    val fechaLimiteInscripcion : String,
    val premio: String,
    val cartel: Bitmap?,
    //val idOrganizator : Int
    //idReserva
)