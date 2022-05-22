package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity

@Entity
class Organizador(
    nickname: String,
    password: String,
    email: String,
    telefono: String,
    tarjetaCredito: String,
    val NIF : String,
    //torneosOrganizados
) : Usuario(nickname, password, email, telefono, tarjetaCredito)