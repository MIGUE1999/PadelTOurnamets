package com.bluetooth.padeltournamets.presentation.view.ui.composables

import android.util.Log
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.bluetooth.padeltournamets.presentation.view.ui.composables.Screen.Login
import com.bluetooth.padeltournamets.presentation.view.ui.composables.Screen.TournamentList
import com.bluetooth.padeltournamets.presentation.view.ui.recipeList.FoodCategory
import com.bluetooth.padeltournamets.presentation.view.ui.recipeList.getAllFoodCategories
import com.bluetooth.padeltournamets.presentation.viewmodel.SearchViewModel


@Composable
fun SearchScreen(mainViewModel: SearchViewModel) {
    val selectedCategory = FoodCategory.CHICKEN
    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    Column()
    {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            elevation = 8.dp,

        ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {
                    SearcherBar()
                }
                CategoryFilter(selectedCategory = selectedCategory)
                TournamentList(numbers = numbers)
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


