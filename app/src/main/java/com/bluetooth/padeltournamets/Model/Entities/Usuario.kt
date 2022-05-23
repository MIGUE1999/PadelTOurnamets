package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 open class Usuario {

    @PrimaryKey(autoGenerate = true)
     var id: Int = 0;
     open var nickname: String = ""
     open var password: String = ""
     open var email: String = ""
     open var telefono: String = ""
     open var tarjetaCredito: String = ""

    constructor(nickname: String, password: String, email: String,
                telefono: String, tarjetaCredito: String)
    {
        this.nickname = nickname
        this.password = password
        this.email = email
        this.telefono = telefono
        this.tarjetaCredito = tarjetaCredito
    }

    override fun toString(): String {
        return "Usuario(id=$id, nickname='$nickname', password='$password', email='$email', telefono='$telefono', tarjetaCredito='$tarjetaCredito')"
    }

}
