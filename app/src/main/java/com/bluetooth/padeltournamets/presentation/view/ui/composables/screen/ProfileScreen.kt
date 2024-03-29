package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
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
import androidx.navigation.NavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.bluetooth.padeltournamets.R.drawable.ic_baseline_emoji_emotions_24
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.TopBar
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.UserViewModel
import com.bluetooth.padeltournamets.utilities.session.LoginPref


@Composable
fun ProfileScreen(session: LoginPref, navController: NavController,userViewModel:UserViewModel,
                  organizatorViewModel: OrganizatorViewModel){
    Scaffold(topBar = { TopBar() }) {

        if(session.getUserDetails().get(LoginPref.KEY_ROL) == Rol.jugador){
            Column(modifier = Modifier.padding(bottom = 40.dp)) {
                TopProfileCard(session, navController, userViewModel, organizatorViewModel)
                ProfilePlayerData()
            }
        }
        else {
            Column(modifier = Modifier.padding(bottom = 40.dp)) {
                TopProfileCard(session, navController,userViewModel,organizatorViewModel)
                ProfileOrganizatorData()
            }
        }

    }
}

@Composable
fun TopProfileCard(session: LoginPref, navController: NavController, userViewModel: UserViewModel,
                   organizatorViewModel: OrganizatorViewModel){
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

            /*
            Image( painter = painterResource(id = ic_baseline_emoji_emotions_24),
                modifier = Modifier
                    .border(width = 80.dp, shape = CircleShape, color = Color.Transparent)
                    .size(60.dp),
                contentDescription = "Profile Photo")

              */

            IconButton(onClick = {
                Log.d("PROFILE SCREEN", "Id: " + session.getUserDetails().get(LoginPref.KEY_ID))
                session.LogoutUser(userViewModel)
                navController.navigate(BottomBarScreen.LogIn.route)
            }) {
                Icon(Icons.Filled.ExitToApp, null)
            }

            Spacer()

            Text("Nombre Usuario", modifier= Modifier
                    .padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = {  } ) {
                Text("Modificar Datos", textAlign = TextAlign.Center, // make text center horizontal
                    modifier = Modifier
                        .wrapContentHeight() )
            }
            Spacer(modifier = Modifier.size(10.dp))
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
            }), focusRequester = passwordFocusRequester)     //valuefied = getNicknameUser

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
            }), focusRequester = passwordFocusRequester) //valuefied = getPasswordUser

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
            }), focusRequester = passwordFocusRequester) //valuefied = getPasswordUser

            TextImput(InputType.Cif, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))
            TextImput(InputType.ClubName, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }))
            TextImput(InputType.BankAccount, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Guardar Cambios", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}





