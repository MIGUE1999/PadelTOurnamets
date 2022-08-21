package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity

@Entity(tableName = "organizador")
data class OrganizatorEntity(
    override var password: String,
    override var email: String,
    override var telefono: String,
    override var nombre: String,
    override var apellido: String,
    var cif : String,
    var clubName : String,
    var bankAccount : String,
    //torneosOrganizados
) : UserEntity(password, email, telefono, nombre, apellido)