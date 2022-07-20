package com.bluetooth.padeltournamets.presentation.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bluetooth.padeltournamets.presentation.view.ui.composables.*
import com.bluetooth.padeltournamets.presentation.view.ui.ui.theme.PadelTOurnametsTheme
import com.bluetooth.padeltournamets.presentation.viewmodel.SearchViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {


    lateinit var navController : NavHostController

    private val searchViewModel: SearchViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent {
            PadelTOurnametsTheme {
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MyApp1()

                }
                 */
                navController = rememberNavController()
                ScaffoldScreen(navController = navController, searchViewModel)

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

