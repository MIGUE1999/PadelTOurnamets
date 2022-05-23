package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
 data class Jugador(
    override var nickname: String,
    override var password: String,
    override var email: String,
    override var telefono: String,
    override var tarjetaCredito: String,
    val nombre : String,
    val apellidos : String
    //torneosGanados
) : Usuario(nickname, password, email, telefono, tarjetaCredito)