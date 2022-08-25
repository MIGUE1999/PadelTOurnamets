package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.PlayerEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.PlayerViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.UserViewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SignUp(userViewModel: UserViewModel, navController : NavController ,
           playerViewModel: PlayerViewModel,
           organizatorViewModel: OrganizatorViewModel,
           context: Context
           )
{
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

            TextImputSignUp(
                inputType = InputType.Name,
                keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }), userViewModel = userViewModel
            )

            TextImputSignUp(InputType.Apellido, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }), userViewModel = userViewModel)

            TextImputSignUp(InputType.Telefono, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }), userViewModel = userViewModel)

            TextImputSignUp(InputType.Correo, keyboardActions = KeyboardActions(onDone = {
                passwordFocusRequester.requestFocus()
            }), userViewModel = userViewModel)

            TextImputSignUp(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester, userViewModel = userViewModel)

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
                TextImputSignUp(InputType.Cif, keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),userViewModel = userViewModel,
                    playerViewModel = playerViewModel,
                    organizatorViewModel = organizatorViewModel)
                TextImputSignUp(InputType.ClubName, keyboardActions = KeyboardActions(onDone = {
                    passwordFocusRequester.requestFocus()
                }),userViewModel = userViewModel,
                    playerViewModel = playerViewModel,
                    organizatorViewModel = organizatorViewModel)
                TextImputSignUp(InputType.BankAccount, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester,

                    userViewModel = userViewModel,
                    playerViewModel = playerViewModel,
                organizatorViewModel = organizatorViewModel)
            }

            if(selectedRol.value == Rol.jugador){
                TextImputSignUp(InputType.Nickname, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester,
                    userViewModel = userViewModel,
                    playerViewModel = playerViewModel)
            }
            Button(onClick = {
                    if(selectedRol.value == Rol.jugador){
                        var usr = UserEntity(
                            nombre = userViewModel.nameUser.value,
                            apellido = userViewModel.surnameUser.value,
                            telefono = userViewModel.tlfUser.value,
                            email = userViewModel.emailUser.value,
                            password = userViewModel.passwordUser.value,
                            rol = Rol.jugador)

                        userViewModel.insertUser(usr)
                        userViewModel.insertPlayerByMail(usr.email, playerViewModel)
                        navController.navigate(BottomBarScreen.LogIn.route)

                    }
                    else if(selectedRol.value == Rol.organizador){
                        var usr = UserEntity(
                            id = 0,
                            nombre = userViewModel.nameUser.value,
                            apellido = userViewModel.surnameUser.value,
                            telefono = userViewModel.tlfUser.value,
                            email = userViewModel.emailUser.value,
                            password = userViewModel.passwordUser.value,
                            rol = Rol.organizador)

                        userViewModel.insertUser(usr)
                        userViewModel.insertOrganizatorByMail(usr.email, organizatorViewModel)
                        navController.navigate(BottomBarScreen.LogIn.route)
                    }
                    else{
                        Toast.makeText(context, "Error al registrarse: Escoge un Rol", Toast.LENGTH_SHORT).show()
                    }
                             },
                modifier = Modifier.fillMaxWidth()) {
                Text("SIGN IN", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

object Rol{
    const val jugador = "Jugador"
    const val organizador = "Organizador"
}




