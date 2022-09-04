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
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.ui.theme.Shapes
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.PlayerViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.UserViewModel
import com.bluetooth.padeltournamets.utilities.session.LoginPref
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait


@Composable
fun Login(userViewModel: UserViewModel, navController: NavController,session : LoginPref,
          organizatorViewModel: OrganizatorViewModel, playerViewModel: PlayerViewModel?){
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

                TextImputLogin(InputType.Correo, keyboardActions = KeyboardActions(onNext = {
                    passwordFocusRequester.requestFocus()
                }), userViewModel = userViewModel)

                TextImputLogin(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                    userViewModel.checkLoginCredentials()
                    focusManager.clearFocus()
                }), focusRequester = passwordFocusRequester,
                    userViewModel = userViewModel
                )

                val lifecycleOwner = LocalLifecycleOwner.current

                userViewModel.usr.observe(lifecycleOwner) { user ->
                    if(user != null) {
                        Log.d("MAIN", "ENTRA ${user.email}")
                        session.createLoginSession(user.id,user.nombre, user.email, user.rol)
                        navController.navigate(BottomBarScreen.Home.route)
                    } else Log.d("MAIN", "NO ENTRA")
                }

                Button(onClick = {
                    userViewModel.checkLoginCredentials()
                },
                    modifier = Modifier.fillMaxWidth()) {
                    Text("Iniciar Sesion", Modifier.padding(vertical = 8.dp))
                }
                Divider(
                    color = Color.White.copy(alpha = 0.3f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 48.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Don't have an account?", color = Color.White)
                    TextButton(onClick = { navController.navigate(BottomBarScreen.SignUp.route) }) {
                        Text("Registrate")
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
        label = "Nombre",
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
    object Cif:InputType(
        label = "CIF",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object ClubName:InputType(
        label = "Nombre del Club",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object BankAccount:InputType(
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
    object Categoria:InputType(
        label = "Categoria",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )
    object FechaInicio:InputType(
        label = "Fecha de inicio del torneo",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )
    object FechaFin:InputType(
        label = "Fecha de fin del torneo",
        icon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )

}

@Composable
fun TextImputLogin(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    userViewModel: UserViewModel? = null
) {

    val value : String

    if(userViewModel != null) {
        if (inputType != InputType.Password) {
            value = userViewModel.emailUser.value
            TextField(
                value = value,
                onValueChange = { inputValue ->
                    userViewModel.onEmailChanged(inputValue)
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
        } else {
            var passwordVisibility by remember { mutableStateOf(false) }

            val icon = if (passwordVisibility)
                painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
            else
                painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)

            value = userViewModel.passwordUser.value
            TextField(
                value = value,
                onValueChange = {inputValue ->
                    userViewModel.onPasswordChanged(inputValue) },
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
                        Icon(painter = icon, contentDescription = "Visibility Icon")
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )
        }
    }
}


@Composable
fun TextImput(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    tournamentViewModel: TournamentViewModel? = null,
    ){

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

@Composable
fun TextImputSignUp(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    userViewModel: UserViewModel? = null,
    playerViewModel: PlayerViewModel? = null,
    organizatorViewModel : OrganizatorViewModel? = null
){

    if(userViewModel != null){
        val value : String
        when(inputType.label){
            InputType.Name.label -> {

                value = userViewModel.nameUser.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        userViewModel.onNameChanged(inputValue)
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
            InputType.Apellido.label -> {
                value = userViewModel.surnameUser.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        userViewModel.onSurnameChanged(inputValue)
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
            InputType.Telefono.label ->{
                value = userViewModel.tlfUser.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        userViewModel.onTlfChanged(inputValue)
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
            InputType.Correo.label ->{
                value = userViewModel.emailUser.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        userViewModel.onEmailChanged(inputValue)
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
            InputType.Password.label ->{

                var passwordVisibility by remember { mutableStateOf(false) }

                val icon = if (passwordVisibility)
                    painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
                else
                    painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)

                value = userViewModel.passwordUser.value
                TextField(
                    value = value,
                    onValueChange = {inputValue ->
                        userViewModel.onPasswordChanged(inputValue) },
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
                            Icon(painter = icon, contentDescription = "Visibility Icon")
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
            }
            InputType.Correo.label ->{
                value = userViewModel.emailUser.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        userViewModel.onEmailChanged(inputValue)
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
            InputType.Nickname.label ->{
                if (playerViewModel != null) {
                    value = playerViewModel.nickname.value

                    TextField(
                        value = value,
                        onValueChange = { inputValue ->
                            playerViewModel.onNicknameChanged(inputValue)
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
            }
            InputType.BankAccount.label -> {

                if (organizatorViewModel != null) {
                    value = organizatorViewModel.bankAccount.value


                    TextField(
                        value = value,
                        onValueChange = { inputValue ->
                            organizatorViewModel.onBankAccountChanged(inputValue)
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

            }
            InputType.Cif.label -> {
                if (organizatorViewModel != null) {
                    value = organizatorViewModel.cif.value


                    TextField(
                        value = value,
                        onValueChange = { inputValue ->
                            organizatorViewModel.onCifChanged(inputValue)
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
            }
            InputType.ClubName.label ->{
                if (organizatorViewModel != null) {
                    value = organizatorViewModel.clubName.value


                    TextField(
                        value = value,
                        onValueChange = { inputValue ->
                            organizatorViewModel.onClubNameChanged(inputValue)
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
            }
            else -> {
                Log.d( "InputText", "No coincide el textfield con ningun label")
            }
        }
    }
}

@Composable
fun TextImputOrganizator(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    organizatorViewModel: OrganizatorViewModel? = null
){

    if(organizatorViewModel != null){
        val value : String
        when(inputType.label){
            InputType.BankAccount.label -> {

                value = organizatorViewModel.bankAccount.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        organizatorViewModel.onBankAccountChanged(inputValue)
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
            InputType.Cif.label -> {
                value = organizatorViewModel.cif.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        organizatorViewModel.onCifChanged(inputValue)
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
            InputType.ClubName.label ->{
                value = organizatorViewModel.clubName.value

                TextField(
                    value = value,
                    onValueChange = { inputValue ->
                        organizatorViewModel.onClubNameChanged(inputValue)
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

@Composable
fun TextEditImput(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions,
    tournamentViewModel: TournamentViewModel? = null,
){

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
