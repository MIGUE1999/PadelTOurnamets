package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bluetooth.padeltournamets.R

@Composable
fun TournamentCard(isOrganizador : Boolean){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ){
        Spacer()
        Row(modifier= Modifier.padding(8.dp)){
            Box(modifier = Modifier.size(120.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_calendar_today_24),
                    contentDescription = "TournamentPoster",
                    modifier = Modifier
                        .padding()
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(color = Color.Blue)
                )
            }
            Spacer()
            Column(
                Modifier.weight(1f),
            ){
                Text("NombreTorneo:", style= MaterialTheme.typography.h5)
                Text("FechaInicio: ")
                Text("FechaFin:")
                Text("Categoria")
                Text("Premio")
            }
            Spacer()
            if(isOrganizador)
                IconButton(onClick= {
                }) {
                    Icon(Icons.Filled.Edit, "EditTournament")
                }
        }
    }
}