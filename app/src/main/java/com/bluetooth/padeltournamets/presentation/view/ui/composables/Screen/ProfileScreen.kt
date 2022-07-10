package com.bluetooth.padeltournamets.presentation.view.ui.composables.Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.bluetooth.padeltournamets.R.drawable.ic_baseline_emoji_emotions_24
import com.bluetooth.padeltournamets.presentation.view.ui.composables.TopBar


@Composable
fun ProfileScreen(rol : String){
    Scaffold(topBar = { TopBar() }) {
        if (rol == Rol.jugador) {
            Column(modifier = Modifier.padding(bottom = 40.dp)) {
                TopProfileCard()
                ProfilePlayerData()
            }
        } else {
            Column(modifier = Modifier.padding(bottom = 40.dp)) {
                TopProfileCard()
                ProfileOrganizatorData()
            }

        }
    }
}

@Composable
fun TopProfileCard(){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .testTag("LoadingCard")
            .height(100.dp)

    ) {
        Row(modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically){
            Image( painter = painterResource(id = ic_baseline_emoji_emotions_24),
                modifier = Modifier
                    .border(width = 80.dp, shape = CircleShape, color = Color.Transparent)
                    .size(60.dp),
                contentDescription = "Profile Photo")

            Spacer()

            Text("Nombre Usuario", modifier= Modifier
                    .padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = {  } ) {
                Text("Modificar Datos", textAlign = TextAlign.Center, // make text center horizontal
                    modifier = Modifier
                        .wrapContentHeight() )
            }
        }
    }
}

@Composable
fun ProfilePlayerData(){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current


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

            TextImput(InputType.Nickname, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester, valueField = "MIGUE1999" )     //valuefied = getNicknameUser

            TextImput(
                inputType = InputType.Name,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),
            )//valuefied = getNameUser

            TextImput(InputType.Apellido, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getApellidoUser

            TextImput(InputType.Correo, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getCorreoUser

            TextImput(InputType.Telefono, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getTFLUser

            TextImput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester, valueField = "123456") //valuefied = getPasswordUser

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Guardar Cambios", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun ProfileOrganizatorData(){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current


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
            TextImput(
                inputType = InputType.Name,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),
            )//valuefied = getNameUser

            TextImput(InputType.Apellido, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getApellidoUser

            TextImput(InputType.Correo, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getCorreoUser

            TextImput(InputType.Telefono, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))//valuefied = getTFLUser

            TextImput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester, valueField = "123456") //valuefied = getPasswordUser

            TextImput(InputType.Nif, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))
            TextImput(InputType.NombreClub, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))
            TextImput(InputType.CuentaBancaria, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Guardar Cambios", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

