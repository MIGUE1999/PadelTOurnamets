package com.bluetooth.padeltournamets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.bluetooth.padeltournamets.Model.Entities.Jugador
import com.bluetooth.padeltournamets.Model.Entities.Usuario
import com.bluetooth.padeltournamets.Model.dataBase.database

class MainActivity : AppCompatActivity() {

    companion object{
        var db : database? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var jugador = Jugador("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865",
        "Miguel Angel", "Tejada")
        db = Room.databaseBuilder(
            applicationContext, database::class.java, "padel_db")
            .allowMainThreadQueries()
            .build()

        var user = Usuario("migue1990", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
        db?.usuarioDao()?.insertUsuario(user)



    }
}