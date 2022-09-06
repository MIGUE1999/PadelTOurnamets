package com.bluetooth.padeltournamets.presentation.view.ui.composables

import android.util.LogPrinter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.presentation.view.ui.composables.screen.Rol
import com.bluetooth.padeltournamets.presentation.view.ui.composables.screen.TournamentList
import com.bluetooth.padeltournamets.presentation.view.ui.recipeList.FoodCategory
import com.bluetooth.padeltournamets.presentation.view.ui.recipeList.getAllFoodCategories
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.SearchViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.bluetooth.padeltournamets.utilities.session.LoginPref


@Composable
fun SearchScreen(mainViewModel: SearchViewModel,
                 tournamentViewModel: TournamentViewModel,
                 organizatorViewModel: OrganizatorViewModel,
                 session:LoginPref,
                 navController:NavController
                 ) {

    //val tournamentViewModel = hiltViewModel<TournamentViewModel>()
    val selectedCategory = FoodCategory.CHICKEN
    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState
    //val allTournaments by tournamentViewModel.getAllTournaments.observeAsState(arrayListOf())

    Column()
    {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.925f),
            color = Color.DarkGray,
            elevation = 8.dp,

        ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)) {
                    SearcherBar()
                }
                CategoryFilter(selectedCategory = selectedCategory)
                if(session.getUserDetails().get(LoginPref.KEY_ROL) == Rol.jugador) {
                TournamentList(tournamentViewModel = tournamentViewModel, organizatorViewModel = organizatorViewModel, false, navController,session)
                }
                else{
                    TournamentList(tournamentViewModel = tournamentViewModel, organizatorViewModel = organizatorViewModel, true, navController,session)
                }
            }
        }
    }
}

@Composable
fun SearcherBar(){
    val textState = remember { mutableStateOf("Search") }


    TextField(
        value = textState.value,
        onValueChange = { newText ->
            textState.value = newText
        },
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(top = 25.dp, end = 8.dp, start = 8.dp, bottom = 8.dp),
        label = { Text(text = "Search") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "SearchIcon"
            )
        },
        keyboardActions = KeyboardActions(onSearch = {
            /* viewModel.newSearch(query)
            keyboardController?.hide()
            */
        }
        )
    )
}

@Composable
fun CategoryFilter(selectedCategory:FoodCategory) {
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp),
    ) {
        items(getAllFoodCategories()){ category ->
            FoodCategoryChip(
                category = category.value,
                isSelected = selectedCategory == category/*
                            onSelectedCategoryChanged = {
                                viewModel.onSelectedCategoryChanged(//it)
                            },
                            onExecuteSearch = viewModel::newSearch,
                            */
            )
        }

    }
}


