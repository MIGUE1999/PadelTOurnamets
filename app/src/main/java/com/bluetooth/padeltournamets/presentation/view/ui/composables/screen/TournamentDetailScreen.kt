package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.presentation.view.savePayments
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.bluetooth.padeltournamets.utilities.session.LoginPref


@Composable
fun TournamentScreen(tournamentViewModel: TournamentViewModel, navController : NavController, session : LoginPref) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current as Activity

    Column(modifier = Modifier.fillMaxSize().background(color= Color.DarkGray)) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .background(color= Color.DarkGray),
                ) {
                    TournamentHeader(
                        scrollState,
                        tournamentViewModel.touchedTournament,
                        this@BoxWithConstraints.maxHeight
                    )
                    TournamentContent(tournamentViewModel.touchedTournament, this@BoxWithConstraints.maxHeight)


                    Button(onClick = {
                        Log.d("Tournament Details", "precionINscripcion: ${tournamentViewModel.touchedTournament!!.precioInscripcion}")
                        if(tournamentViewModel.touchedTournament!!.precioInscripcion != null)
                            savePayments(tournamentViewModel.touchedTournament!!.precioInscripcion.toInt(), context)
                     }, modifier = Modifier.fillMaxWidth())
                    { Text("Inscribirse") }

                }
            }
        }
    }


}

@Composable
private fun TournamentHeader(
    scrollState: ScrollState,
    tournament: TournamentEntity?,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    if (tournament != null) {
        Image(
            modifier = Modifier
                .heightIn(max = containerHeight / 2)
                .fillMaxWidth()
                .padding(top = offsetDp),
            bitmap = tournament.cartel!!.asImageBitmap(),
            //painter = painterResource(id = puppy.puppyImageId),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

}

@Composable
private fun TournamentContent(tournament: TournamentEntity?, containerHeight: Dp) {
    Column(modifier=Modifier.background(color= Color.DarkGray)) {
        Spacer(modifier = Modifier.height(8.dp))

        Name(tournament)

        if (tournament != null) {

            TournamentProperty(InputType.Categoria.label, tournament.categoria)

            TournamentProperty(InputType.Premio.label, tournament.premio)

            TournamentProperty(InputType.PrecioInscripcion.label, tournament.precioInscripcion)

            TournamentProperty(InputType.FechaInicio.label, tournament.fechaInicio)

            TournamentProperty(InputType.FechaFin.label, tournament.fechaFin)

            TournamentProperty(InputType.FechaLimiteInscripcion.label, tournament.fechaLimiteInscripcion)


            // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
            // in order to always leave some content at the top.
            //Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
        }


    }
}

@Composable
private fun Name(
    tournament: TournamentEntity?
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        NameD(
            tournament = tournament,
            //modifier = Modifier.baselineHeight(32.dp)
        )
    }
}

@Composable
private fun NameD(tournament: TournamentEntity?) {
    if (tournament != null) {
        Text(
            text = tournament.nombre,
            color = Color.White,
            //modifier = modifier,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TournamentProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                color=Color.White,
                //modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            color=Color.White,
            //modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}