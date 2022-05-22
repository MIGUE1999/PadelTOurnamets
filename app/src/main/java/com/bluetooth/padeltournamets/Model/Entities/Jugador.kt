package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
 class Jugador(
    nickname: String,
    password: String,
    email: String,
    telefono: String,
    tarjetaCredito: String,
    var nombre : String,
    var apellidos : String
    //torneosGanados
) : Usuario(nickname, password, email, telefono, tarjetaCredito)