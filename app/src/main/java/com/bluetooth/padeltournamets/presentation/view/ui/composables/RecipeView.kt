package com.bluetooth.padeltournamets.presentation.view.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bluetooth.padeltournamets.R

import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RecipeView(
    //recipe: Recipe,
){

    Column(modifier = Modifier.fillMaxWidth()) {
        TournamentDetails()
    }

}

@Composable
fun TournamentDetails(){
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
            ,
            contentScale = ContentScale.Crop,
            contentDescription = "Tournament Detail Photo"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                ){
                    Text(
                        text = "TituloTorneo",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start)
                        ,
                        style = MaterialTheme.typography.h3
                    )

                }

                Text(
                    text = "Fecha Inicio",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                    ,
                    style = MaterialTheme.typography.body1
                )

                Text(
                    text = "Fecha Fin",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                    ,
                    style = MaterialTheme.typography.body1
                )

                Text(
                    text = "PrecioInscripcion",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                    ,
                    style = MaterialTheme.typography.body1
                )


                Text(
                    text = "Premio",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                    ,
                    style = MaterialTheme.typography.body1
                )
                Button(onClick = { /*TODO*/ }, modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)) {
                    Text(text = "Inscribirse al torneo")
                }
        }
}