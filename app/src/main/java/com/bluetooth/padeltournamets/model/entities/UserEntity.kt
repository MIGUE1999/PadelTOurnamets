package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
 open class UserEntity {

    @PrimaryKey(autoGenerate = true)
     var id: Int = 0
     open var nombre: String = ""
     open var password: String = ""
     open var email: String = ""
     open var telefono: String = ""
     open var apellido: String = ""

    constructor(nombre: String, password: String, email: String,
                telefono: String, apellido: String)
    {
        this.nombre = nombre
        this.password = password
        this.email = email
        this.telefono = telefono
        this.apellido = apellido
    }

    override fun toString(): String {
        return "Usuario(id=$id, nombre='$nombre', password='$password', email='$email', telefono='$telefono', apellido='$apellido')"
    }
}
