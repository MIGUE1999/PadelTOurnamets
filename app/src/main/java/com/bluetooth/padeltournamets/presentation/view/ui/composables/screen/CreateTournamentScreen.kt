package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import android.content.Context
import android.util.Log

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.presentation.view.ui.composables.PickImageFromGallery
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.showDatePicker
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.bluetooth.padeltournamets.utilities.INICIO_TORNEO
import com.bluetooth.padeltournamets.utilities.FIN_TORNEO
import com.bluetooth.padeltournamets.utilities.session.LoginPref


@Composable
fun CreateTournament(context : Context, navController: NavController,
                     tournamentViewModel : TournamentViewModel,
                    organizatorViewModel: OrganizatorViewModel,
                     session : LoginPref
){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current

    //val tournamentViewModel = hiltViewModel<TournamentViewModel>()

    /*
    val tournament = TournamentEntity(id = 0 ,nombre="Torneo canada", categoria = "1",
        precioInscripcion = "10", fechaInicio = "Lunes", fechaFin = "Martes",
        fechaLimiteInscripcion = "Manana", premio = "50")
*/
    val selectedCategory = remember{
        mutableStateOf("")
    }

    ProvideWindowInsets {
        Column(
            Modifier
                .navigationBarsWithImePadding()
                .padding(24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Crear Torneo", fontSize = 40.sp, color = Color.White)

            TextImput(
                inputType = InputType.NombreTorneo,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }), tournamentViewModel = tournamentViewModel
            )

            TextImput(InputType.FechaLimiteInscripcion, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }), tournamentViewModel = tournamentViewModel)

            TextImput(InputType.Premio, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }), tournamentViewModel = tournamentViewModel)

            TextImput(InputType.PrecioInscripcion, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester, tournamentViewModel = tournamentViewModel)

            Text(text = "Seleccione Categoria", color = Color.White)
            Row {
                RadioButton(
                    selected = tournamentViewModel.category.value == Categoria.primera,
                    onClick =
                    {
                        tournamentViewModel.onCategoryChanged(Categoria.primera)
                    },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.primera, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

                RadioButton(
                    selected = tournamentViewModel.category.value == Categoria.segunda,
                    onClick =
                    {
                        tournamentViewModel.onCategoryChanged(Categoria.segunda)
                    },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.segunda, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

                RadioButton(
                    selected = tournamentViewModel.category.value == Categoria.tercera,
                    onClick =
                    {
                        tournamentViewModel.onCategoryChanged(Categoria.tercera)
                    },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.tercera, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

            }
            showDatePicker(context, INICIO_TORNEO, FIN_TORNEO, tournamentViewModel = tournamentViewModel)

            PickImageFromGallery(tournamentViewModel)

            Button(onClick = {
                var idUsr = 0
                session.getUserDetails().get(LoginPref.KEY_ID)?.let {
                    idUsr = session.getUserDetails().get(LoginPref.KEY_ID)!!.toInt()
                }
                var tournament = TournamentEntity(nombre = tournamentViewModel.nameTournament.value,
                    precioInscripcion = tournamentViewModel.inscriptionCost.value,
                    premio = tournamentViewModel.priceTournament.value,
                    categoria = tournamentViewModel.category.value,
                    fechaInicio = tournamentViewModel.dateIni.value,
                    fechaFin = tournamentViewModel.dateFin.value,
                    cartel = tournamentViewModel.cartel.value,
                    fechaLimiteInscripcion = tournamentViewModel.dateLimit.value,
                    idOrganizator = idUsr
                )
                Log.d("CREATETOURNAMENT","ID USUARIO: $idUsr" )
                tournamentViewModel.insertTournament(tournament)
                Log.d("CreatePreNav", tournamentViewModel.getAllTournaments.toString())
                navController.navigate(BottomBarScreen.Home.route)
                Log.d("CreatePostNav", tournamentViewModel.getAllTournaments.value.toString())
            }, modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                Text(text = "Crear Torneo")
            }

        }
    }
}

object Categoria{
    const val primera = "Primera"
    const val segunda = "Segunda"
    const val tercera = "Tercera"
}