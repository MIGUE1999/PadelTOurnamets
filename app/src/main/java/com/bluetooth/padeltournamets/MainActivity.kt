package com.bluetooth.padeltournamets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bluetooth.padeltournamets.Model.Entities.Jugador

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var jugador = Jugador("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865",
        "Miguel Angel", "Tejada")


    }
}