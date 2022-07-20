package com.bluetooth.padeltournamets.presentation.view.ui.composables.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluetooth.padeltournamets.presentation.view.ui.ui.theme.Shapes
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding


@Composable
fun Login(){
    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current

        ProvideWindowInsets {
            Column(
                Modifier
                    .navigationBarsWithImePadding()
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text="Padel Tournaments",
                    color = White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier=Modifier.padding(bottom = 30.dp) )

                TextImput(InputType.Name, keyboardActions = KeyboardActions(onNext = {
                    passwordFocusRequester.requestFocus()
                }))

                TextImput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester)

                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("SIGN IN", Modifier.padding(vertical = 8.dp))
                }
                Divider(
                    color = Color.White.copy(alpha = 0.3f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 48.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Don't have an account?", color = Color.White)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("SING UP")
                    }
                }
            }
        }

}

sealed class InputType(val label:String,
                       val icon: ImageVector?,
                       val keyboardOptions: KeyboardOptions,
                        val visualTransformation: VisualTransformation)
{
    object Name:InputType(
        label = "Name",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
        )
    object Apellido:InputType(
        label = "Apellido",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Correo:InputType(
        label = "Correo",
        icon = Icons.Default.Email,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object Telefono:InputType(
        label = "Telefono",
        icon = Icons.Default.Phone,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
    //jugador
    object Nickname:InputType(
        label = "Nickname",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    //Organizador
    object Nif:InputType(
        label = "NIF",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object NombreClub:InputType(
        label = "Nombre del Club",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object CuentaBancaria:InputType(
        label = "IBAN",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object NombreTorneo:InputType(
        label = "Nombre del Torneo",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Premio:InputType(
        label = "Premio",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object PrecioInscripcion:InputType(
        label = "Precio de Inscripcion del Torneo",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )

    object FechaLimiteInscripcion:InputType(
        label = "Fecha limite de Inscripcion al Torneo",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )

}

@Composable
fun TextImput(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    tournamentViewModel: TournamentViewModel? = null
    ){
/*
    var value by remember { mutableStateOf("") }

    if(inputType != InputType.Password) {
        TextField(
            value = value,
            onValueChange = { value = it },
            modifier = Modifier
                .fillMaxWidth()
                .focusOrder(focusRequester ?: FocusRequester()),
            leadingIcon = {
                if (inputType.icon != null)
                    Icon(imageVector = inputType.icon, null)
            },
            label = { Text(text = inputType.label) },
            shape = Shapes.small,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = inputType.keyboardOptions,
            visualTransformation = inputType.visualTransformation,
            keyboardActions = keyboardActions
            )
    }
    else{
        var passwordVisibility by remember { mutableStateOf(false)}

        val icon = if(passwordVisibility)
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
        else
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)

        TextField(
            value = value,
            onValueChange = { value = it },
            modifier = Modifier
                .fillMaxWidth()
                .focusOrder(focusRequester ?: FocusRequester()),
            leadingIcon = {
                if (inputType.icon != null)
                    Icon(imageVector = inputType.icon, null)
            },
            label = { Text(text = inputType.label) },
            shape = Shapes.small,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = inputType.keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(painter = icon, contentDescription ="Visibility Icon" )
                }
            },
            visualTransformation = if(passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }
    */


    if(tournamentViewModel != null){
        val value : String
        when(inputType.label){
            InputType.NombreTorneo.label -> {

                value = tournamentViewModel.nameTournament.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        tournamentViewModel.onNameChanged(inputValue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusOrder(focusRequester ?: FocusRequester()),
                    leadingIcon = {
                        if (inputType.icon != null)
                            Icon(imageVector = inputType.icon, null)
                    },
                    label = { Text(text = inputType.label) },
                    shape = Shapes.small,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    keyboardOptions = inputType.keyboardOptions,
                    visualTransformation = inputType.visualTransformation,
                    keyboardActions = keyboardActions
                )

            }
            InputType.Premio.label -> {
                value = tournamentViewModel.priceTournament.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        tournamentViewModel.onPriceChanged(inputValue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusOrder(focusRequester ?: FocusRequester()),
                    leadingIcon = {
                        if (inputType.icon != null)
                            Icon(imageVector = inputType.icon, null)
                    },
                    label = { Text(text = inputType.label) },
                    shape = Shapes.small,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    keyboardOptions = inputType.keyboardOptions,
                    visualTransformation = inputType.visualTransformation,
                    keyboardActions = keyboardActions
                )
            }
            InputType.PrecioInscripcion.label ->{
                value = tournamentViewModel.inscriptionCost.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        tournamentViewModel.onInscriptionCostChanged(inputValue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusOrder(focusRequester ?: FocusRequester()),
                    leadingIcon = {
                        if (inputType.icon != null)
                            Icon(imageVector = inputType.icon, null)
                    },
                    label = { Text(text = inputType.label) },
                    shape = Shapes.small,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    keyboardOptions = inputType.keyboardOptions,
                    visualTransformation = inputType.visualTransformation,
                    keyboardActions = keyboardActions
                )
            }
            InputType.FechaLimiteInscripcion.label ->{
                value = tournamentViewModel.dateLimit.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        tournamentViewModel.onDateLimitChanged(inputValue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusOrder(focusRequester ?: FocusRequester()),
                    leadingIcon = {
                        if (inputType.icon != null)
                            Icon(imageVector = inputType.icon, null)
                    },
                    label = { Text(text = inputType.label) },
                    shape = Shapes.small,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    keyboardOptions = inputType.keyboardOptions,
                    visualTransformation = inputType.visualTransformation,
                    keyboardActions = keyboardActions
                )
            }
            else -> {
                Log.d( "InputText", "No coincide el textfield con ningun label")
            }
        }


    }
}
