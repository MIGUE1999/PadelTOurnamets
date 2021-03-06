package com.bluetooth.padeltournamets.presentation.view.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.screen.*
import com.bluetooth.padeltournamets.presentation.viewmodel.SearchViewModel

//Es el que muestra la pantalla en el scaffold: content = {BottomNavGraph(navController = navController)},
@Composable
fun BottomNavGraph(navController: NavHostController, searchViewModel: SearchViewModel) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(searchViewModel)
        }
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(Rol.organizador)
        }
        composable(route = BottomBarScreen.CreateTournament.route) {
            CreateTournament(context = context, navController)
        }
    }
}