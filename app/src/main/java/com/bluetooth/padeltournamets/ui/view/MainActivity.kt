package com.bluetooth.padeltournamets.ui.view


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import com.bluetooth.padeltournamets.ui.view.ui.theme.PadelTOurnametsTheme
import com.bluetooth.padeltournamets.ui.viewmodel.UsuarioViewModel
import com.valentinilk.shimmer.shimmer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        setContent {
            PadelTOurnametsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp1()
                }
            }
        }

        /*
        val jugador = JugadorEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865",
        "Miguel Angel", "Tejada")
        val user = UsuarioEntity("migue1990", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
        val user2 = UsuarioEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
    */
    }

    @Composable
    fun MyApp1(
        usuarioViewModel: UsuarioViewModel = hiltViewModel(),
    ) {
        val usuarios by usuarioViewModel.allUsers.observeAsState(arrayListOf())
        val isLoading by usuarioViewModel.isLoading.observeAsState(false)
            MyApp(
                onAddClick = {

                    Log.d("MAIN", "anade usuario")
                    usuarioViewModel.insertUsuario()
                },
                onDeleteClick={
                    usuarioViewModel.deleteUsuario(it)
                },
                users = usuarios,
                isLoading = isLoading
                )
        }
    }

    @Composable
    fun MyApp(
        onAddClick: (() -> Unit)? = null,
        onDeleteClick: ((usuarioABorrar: UsuarioEntity)-> Unit)? = null,
        users: List<UsuarioEntity>,
        isLoading: Boolean
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Padel Tournaments") },
                    actions = {
                        IconButton(onClick = {
                            onAddClick?.invoke()
                        }) {
                            Icon(Icons.Filled.Add, "Add")
                        }
                    }
                )
            }
        ) {
            LazyColumn {
                var itemCount = users.size
                if(isLoading) itemCount++

                items(count = itemCount){ index ->
                    var auxIndex = index
                    if(isLoading){
                        if(auxIndex == 0)
                            return@items LoadingCard()
                        auxIndex--
                    }
                    val user = users[auxIndex]
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = 1.dp,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth()
                    ){
                        Row(modifier= Modifier.padding(8.dp)){
                          Spacer()
                            Column(
                                Modifier.weight(1f),
                            ){
                                Text("${user.email} ${user.nickname}")
                                Text("${user.id}")
                            }
                            Spacer()
                            IconButton(onClick= {
                                onDeleteClick?.invoke(user)
                            }) {
                                Icon(Icons.Filled.Delete, "Remove")

                            }

                        }

                    }
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

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PadelTOurnametsTheme {
            MyApp(onAddClick = null, users = listOf(), isLoading = true)
        }
    }
