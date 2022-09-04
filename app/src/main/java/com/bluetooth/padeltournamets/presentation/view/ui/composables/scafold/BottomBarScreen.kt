package com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object CreateTournament : BottomBarScreen(
        route = "create_tournament",
        title = "CreateTournament",
        icon = Icons.Default.Add
    )
    object EditTournament : BottomBarScreen(
        route = "edit_tournament",
        title = "EditTournament",
        icon = Icons.Default.Add
    )
    object LogIn : BottomBarScreen(
        route = "log_in",
        title = "LogIn",
        icon = Icons.Default.Add
    )
    object SignUp : BottomBarScreen(
        route = "sign_up",
        title = "SignUp",
        icon = Icons.Default.Add
    )

    object TournamentDetail : BottomBarScreen(
        route = "tournament_detail",
        title = "TournamentDetail",
        icon = Icons.Default.Add
    )
}