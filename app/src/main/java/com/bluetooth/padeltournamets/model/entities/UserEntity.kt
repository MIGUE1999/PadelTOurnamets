package com.bluetooth.padeltournamets.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
 data class UserEntity(
   @PrimaryKey(autoGenerate = true)
   var id: Int = 0,
   var nombre: String,
   var password: String,
   var email: String,
   var telefono: String,
   var apellido: String,
   var rol : String
)

