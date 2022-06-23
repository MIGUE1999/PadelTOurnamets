package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity

@Entity
 data class JugadorEntity(
    override var nickname: String,
    override var password: String,
    override var email: String,
    override var telefono: String,
    override var tarjetaCredito: String,
    val nombre : String,
    val apellidos : String
    //torneosGanados
) : UsuarioEntity(nickname, password, email, telefono, tarjetaCredito)