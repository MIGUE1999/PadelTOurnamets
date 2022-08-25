package com.bluetooth.padeltournamets.presentation.view.ui.composables

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBar
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.screen.*
import com.bluetooth.padeltournamets.presentation.viewmodel.*

//Es el que muestra la pantalla en el scaffold: content = {BottomNavGraph(navController = navController)},
@Composable
fun BottomNavGraph(navController: NavHostController, searchViewModel: SearchViewModel,
                   tournamentViewModel : TournamentViewModel,
                   userViewModel: UserViewModel,
                   playerViewModel: PlayerViewModel,
                   organizatorViewModel : OrganizatorViewModel
                   ) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.LogIn.route
    ) {
        composable(route = BottomBarScreen.Search.route) {
            Scaffold(
                content = {SearchScreen(searchViewModel, tournamentViewModel)},
                //floatingActionButton = {FAB(navController = navController)},
                bottomBar = { BottomBar(navController = navController,) }
            )
        }
        composable(route = BottomBarScreen.Home.route) {
            Scaffold(
                content = { HomeScreen(tournamentViewModel)},
                //floatingActionButton = {FAB(navController = navController)},
                bottomBar = { BottomBar(navController = navController,) }
            )

        }
        composable(route = BottomBarScreen.Profile.route) {
            Scaffold(
                content = { ProfileScreen(Rol.organizador) },
                //floatingActionButton = {FAB(navController = navController)},
                bottomBar = { BottomBar(navController = navController,) }
            )
        }
        composable(route = BottomBarScreen.CreateTournament.route) {
            Scaffold(
                content = {CreateTournament(context = context, navController, tournamentViewModel = tournamentViewModel, organizatorViewModel = organizatorViewModel)},
                //floatingActionButton = {FAB(navController = navController)},
                bottomBar = { BottomBar(navController = navController,) }
            )

        }
        composable(route = BottomBarScreen.LogIn.route) {
            Login(userViewModel, navController)
        }
        composable(route = BottomBarScreen.SignUp.route) {
            SignUp(userViewModel = userViewModel, navController, playerViewModel,
                organizatorViewModel = organizatorViewModel , context )
        }
    }
}