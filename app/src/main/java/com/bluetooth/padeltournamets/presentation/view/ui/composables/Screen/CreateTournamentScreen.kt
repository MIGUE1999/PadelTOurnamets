package com.bluetooth.padeltournamets.presentation.view.ui.composables.Screen

import android.content.Context

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluetooth.padeltournamets.presentation.view.ui.composables.PickImageFromGallery
import com.bluetooth.padeltournamets.presentation.view.ui.composables.showDatePicker
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.bluetooth.padeltournamets.utilities.INICIO_TORNEO
import com.bluetooth.padeltournamets.utilities.FIN_TORNEO

@Composable
fun CrearTorneo(context : Context){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current

    val selectedCategory = remember{
        mutableStateOf("")
    }

    ProvideWindowInsets {
        Column(
            Modifier
                .navigationBarsWithImePadding()
                .padding(24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Crear Torneo", fontSize = 40.sp, color = Color.White)

            TextImput(
                inputType = InputType.NombreTorneo,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),
            )

            TextImput(InputType.Premio, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))

            TextImput(InputType.PrecioInscripcion, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)

            Text(text = "Seleccione Categoria", color = Color.White)
            Row {
                RadioButton(
                    selected = selectedCategory.value == Categoria.primera,
                    onClick = { selectedCategory.value = Categoria.primera },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.primera, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

                RadioButton(
                    selected = selectedCategory.value == Categoria.segunda,
                    onClick = { selectedCategory.value = Categoria.segunda},
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.segunda, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

                RadioButton(
                    selected = selectedCategory.value == Categoria.tercera,
                    onClick = { selectedCategory.value = Categoria.tercera },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Categoria.tercera, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

            }
            showDatePicker(context, INICIO_TORNEO, FIN_TORNEO)

            PickImageFromGallery()

            Button(onClick = {  }, modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                Text(text = "Crear Torneo")
            }

        }
    }
}

object Categoria{
    const val primera = "Primera"
    const val segunda = "Segunda"
    const val tercera = "Tercera"
}