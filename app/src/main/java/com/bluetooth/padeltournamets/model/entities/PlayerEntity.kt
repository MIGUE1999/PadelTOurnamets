package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity


@Entity(tableName = "jugador")
 data class PlayerEntity(
    override var nombre: String,
    override var password: String,
    override var email: String,
    override var telefono: String,
    override var apellido : String,
    val nickname : String
    //torneosGanados
) : UserEntity(nombre, password, email, telefono, apellido)