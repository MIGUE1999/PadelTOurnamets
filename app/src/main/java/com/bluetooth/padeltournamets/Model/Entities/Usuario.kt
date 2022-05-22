package com.bluetooth.padeltournamets.Model.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 open class Usuario {

    @PrimaryKey(autoGenerate = true)
     var id: Int = 0;
     var nickname: String = ""
     var password: String = ""
     var email: String = ""
     var telefono: String = ""
     var tarjetaCredito: String = ""

    constructor(nickname: String, password: String, email: String,
                telefono: String, tarjetaCredito: String)
    {
        this.nickname = nickname
        this.password = password
        this.email = email
        this.telefono = telefono
        this.tarjetaCredito = tarjetaCredito
    }
}
