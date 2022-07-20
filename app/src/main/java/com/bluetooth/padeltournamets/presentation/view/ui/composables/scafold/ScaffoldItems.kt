package com.bluetooth.padeltournamets.presentation.view.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.ui.theme.GreenTenis
import com.bluetooth.padeltournamets.presentation.viewmodel.SearchViewModel


@Composable
fun ScaffoldScreen(navController: NavHostController, searchViewModel : SearchViewModel = hiltViewModel())
{
    Scaffold(
        content = {BottomNavGraph(navController = navController, searchViewModel)},
        floatingActionButton = {FAB(navController = navController)},
        bottomBar = { BottomBar(navController = navController,) }
    )
}

@Composable
fun TopBar(){
    TopAppBar(
            backgroundColor = Color.DarkGray,
            modifier = Modifier
                .height(100.dp)
                .wrapContentHeight(CenterVertically),
            title = { Text("Padel Tournaments", color = Color.White) }
        )

}

@Composable
fun FAB(navController: NavController){
    FloatingActionButton(onClick = {
        navController.navigate(BottomBarScreen.CreateTournament.route)
    }, backgroundColor= Color.Green){
        Icon(imageVector = Icons.Default.Add, "Crear Torneo")
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Search,
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(modifier = Modifier.height(65.dp),
                    backgroundColor = GreenTenis ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}




