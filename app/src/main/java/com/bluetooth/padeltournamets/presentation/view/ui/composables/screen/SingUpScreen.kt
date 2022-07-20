package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding


@Composable
fun SingUp(){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current

    val selectedRol = remember{
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
            Box(
                modifier = Modifier.padding(top = 80.dp)
            )

            TextImput(
                inputType = InputType.Name,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),
            )

            TextImput(InputType.Apellido, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))

            TextImput(InputType.Correo, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))

            TextImput(InputType.Telefono, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))

            TextImput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)

            Text(text = "Seleccione su rol", modifier = Modifier.padding(0.dp), color = Color.White)

            Row {
                RadioButton(
                    selected = selectedRol.value == Rol.jugador,
                    onClick = { selectedRol.value = Rol.jugador },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Rol.jugador, color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

                RadioButton(
                    selected = selectedRol.value == Rol.organizador,
                    onClick = { selectedRol.value = Rol.organizador },
                    colors = RadioButtonDefaults.colors(Color.Green)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(Rol.organizador, color = Color.White)

            }

            if(selectedRol.value == Rol.organizador){
                TextImput(InputType.Nif, keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }))
                TextImput(InputType.NombreClub, keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }))
                TextImput(InputType.CuentaBancaria, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester)
            }

            if(selectedRol.value == Rol.jugador){
                TextImput(InputType.Nickname, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester)
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("SIGN IN", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

object Rol{
    const val jugador = "Jugador"
    const val organizador = "Organizador"
}




