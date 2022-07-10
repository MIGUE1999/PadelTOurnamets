package com.bluetooth.padeltournamets.presentation.view.ui.composables.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bluetooth.padeltournamets.presentation.view.ui.composables.TopBar
import com.bluetooth.padeltournamets.presentation.viewmodel.UsuarioViewModel
import com.valentinilk.shimmer.shimmer

@Composable
fun HomeScreen(
    usuarioViewModel: UsuarioViewModel = hiltViewModel(),
) {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    Scaffold(topBar = { TopBar() }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Tus Torneos", color = Color.White, style = MaterialTheme.typography.h3)
            TournamentList(numbers = numbers)
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
fun TournamentList(numbers : List<Int>)
{
    LazyColumn() {
        var itemCount = numbers.size
        items(count = itemCount) {
            TournamentCard(isOrganizador = true)
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
