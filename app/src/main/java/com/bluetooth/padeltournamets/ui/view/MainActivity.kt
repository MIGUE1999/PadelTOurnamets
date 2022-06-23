package com.bluetooth.padeltournamets.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.bluetooth.padeltournamets.model.entities.JugadorEntity
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import com.bluetooth.padeltournamets.R
import com.bluetooth.padeltournamets.ui.viewmodel.UsuarioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val userViewModel : UsuarioViewModel by viewModels()

        setContent{
            Surface(color = MaterialTheme.colors.background) {
                Greeting("Android")
            }
        }
    /*
        val jugador = JugadorEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865",
        "Miguel Angel", "Tejada")
        val user = UsuarioEntity("migue1990", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
        val user2 = UsuarioEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
    */
    }
}

@Composable
fun Greeting(name: String,
             usrViewModel : UsuarioViewModel = hiltViewModel()
) {
    Button(onClick = {
        usrViewModel.getUsuarios()
    }) {

    }
}