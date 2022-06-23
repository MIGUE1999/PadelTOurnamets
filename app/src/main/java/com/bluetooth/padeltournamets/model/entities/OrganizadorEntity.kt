package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity

@Entity
data class OrganizadorEntity(
    override var nickname: String,
    override var password: String,
    override var email: String,
    override var telefono: String,
    override var tarjetaCredito: String,
    var NIF : String,
    //torneosOrganizados
) : UsuarioEntity(nickname, password, email, telefono, tarjetaCredito)