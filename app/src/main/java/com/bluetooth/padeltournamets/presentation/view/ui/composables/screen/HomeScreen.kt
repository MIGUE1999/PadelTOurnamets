package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.R
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.FAB
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.TopBar
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.bluetooth.padeltournamets.utilities.session.LoginPref
import com.bluetooth.padeltournamets.utilities.session.LoginPref.Companion.KEY_EMAIL
import com.bluetooth.padeltournamets.utilities.session.LoginPref.Companion.KEY_ORG_ID
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    organizatorViewModel: OrganizatorViewModel,
    tournamentViewModel: TournamentViewModel,
    session : LoginPref,
    navController: NavController
) {

    if(session.getUserDetails().get(LoginPref.KEY_ROL) == Rol.jugador) {
        Scaffold(topBar = { TopBar() }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Tus Torneos", color = Color.White, style = MaterialTheme.typography.h3)
                TournamentList(tournamentViewModel = tournamentViewModel, organizatorViewModel,
                    false, navController, session)
            }
        }
    }
    else {
        Scaffold(topBar = { TopBar() }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight(0.9f)) {
                Button(onClick = {
                    tournamentViewModel.clearTournamentForm()
                    navController.navigate(BottomBarScreen.CreateTournament.route)
                }) {
                    Text(text = "Crear Torneo", color = Color.White, style = MaterialTheme.typography.h3)
                }
                Spacer()

                TournamentList(tournamentViewModel = tournamentViewModel, organizatorViewModel,
                    true, navController, session)
            }
        }
    }


    /*
    val usuarios by usuarioViewModel.allUsers.observeAsState(arrayListOf())
    val isLoading by usuarioViewModel.isLoading.observeAsState(false)
    TournamentList(
        onDeleteClick={
            usuarioViewModel.deleteUsuario(it)
        },
        users = usuarios,
        isLoading = isLoading
    )
    */

}

@Composable
fun TournamentList(tournamentViewModel : TournamentViewModel,
                   organizatorViewModel: OrganizatorViewModel,
                   isOrganizator : Boolean,
                   navController: NavController,
                   session: LoginPref
                   ) {
    val tournaments by tournamentViewModel.getAllTournaments.observeAsState(arrayListOf())
    tournamentViewModel.onActualSessionChanged(session)
    val tournamentsByOrgId = tournamentViewModel.getTournametsByOrgId
    val tournamentsByOrgIdState by tournamentsByOrgId.observeAsState(arrayListOf())
    //val tournamentsByOrgId by tournamentViewModel.getTournametsByOrgId.observeAsState(listOf())
    //val lifecycleOwner = LocalLifecycleOwner.current

    if(isOrganizator) {
            LazyColumn() {
                    items(items = tournamentsByOrgIdState) { tournament ->
                        TournamentCard(
                            isOrganizador = true,
                            tournament,
                            tournamentViewModel,
                            navController
                        )
                    }
            }
    }
    else{
        LazyColumn() {
            items(items = tournaments) { tournament ->
                TournamentCard(isOrganizador = true, tournament, tournamentViewModel, navController)
            }
        }
    }
}



@Composable
fun LoadingCard(){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .testTag("LoadingCard")
    ) {
        Row(modifier = Modifier.padding(8.dp)){
            ImageLoading()
            Spacer()
            Column{
                Spacer()
                Box(modifier = Modifier.shimmer()){
                    Column {
                        Box(
                            modifier = Modifier
                                .height(15.dp)
                                .fillMaxWidth()
                                .background(Color.Gray)
                        )
                        Spacer()
                        Box(
                            modifier = Modifier
                                .height(15.dp)
                                .fillMaxWidth()
                                .background(Color.Gray)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageLoading(){
    Box(modifier = Modifier.shimmer()){
        Box(
            modifier= Modifier
                .size(50.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun Spacer(size: Int = 8) = Spacer(modifier = Modifier.size(size.dp))
