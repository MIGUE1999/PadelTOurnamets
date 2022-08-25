package com.bluetooth.padeltournamets.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.PlayerEntity
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IOrganizatorRepository
import com.bluetooth.padeltournamets.model.repository.interfaces.IPlayerRepository
import com.bluetooth.padeltournamets.model.repository.interfaces.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*


import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository : IUserRepository,
) : ViewModel()
{
    val emailUser = mutableStateOf("")
    val nameUser = mutableStateOf("")
    val surnameUser = mutableStateOf("")
    val passwordUser = mutableStateOf("")
    val tlfUser = mutableStateOf("")
    val returnedUserId = MutableLiveData<Int>()
    var idUsr = 0

    val getAllUsers : LiveData<List<UserEntity>> by lazy {
        userRepository.getAllUsers()
    }


    fun getUserById(id:Int) : LiveData<UserEntity> {
        return  userRepository.getUser(id)
    }


    fun insertUser(user : UserEntity){
            viewModelScope.launch {
                userRepository.insertUser(user)
            }
    }

    fun deleteUser(usr : UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(usr)
        }
    }

    fun updateUser(user : UserEntity){
        viewModelScope.launch{
            userRepository.modifyUser(user)
        }
    }

    fun onEmailChanged(email:String){
        emailUser.value = email
    }
    fun onNameChanged(name:String){
        nameUser.value = name
    }
    fun onSurnameChanged(surname:String){
        surnameUser.value = surname
    }

    fun onPasswordChanged(pass:String){
        passwordUser.value = pass
    }

    fun onTlfChanged(tlf:String){
        tlfUser.value = tlf
    }

//use cases

    fun insertPlayerByMail(mail:String, playerViewModel: PlayerViewModel){
        viewModelScope.launch(Dispatchers.IO) {
            idUsr = userRepository.getIdByMail(mail)
            Log.d("PRUEBA", "IdAntes: ${idUsr}")
            var player = PlayerEntity(nickname = playerViewModel.nickname.value, userId = idUsr )
            Log.d("PRUEBA", "NickAntes: ${player.nickname}")
            Log.d("PRUEBA", "UserIdAntes: ${player.userId}")

            playerViewModel.insertPlayer(player)
        }
        Log.d("PRUEBA", "IdDespues: ${idUsr}")
    }

    fun insertOrganizatorByMail(mail:String, organizatorViewModel: OrganizatorViewModel){
        viewModelScope.launch(Dispatchers.IO) {
            idUsr = userRepository.getIdByMail(mail)
            var organizator = OrganizatorEntity(cif = organizatorViewModel.cif.value ,
                clubName=organizatorViewModel.clubName.value,
                bankAccount= organizatorViewModel.bankAccount.value, userId = idUsr )
            organizatorViewModel.insertOrganizator(organizator)
        }
    }

    fun checkLoginCredentials() {
        viewModelScope.launch{
            var usr = userRepository.getUserByCredentials(emailUser.value, passwordUser.value)
            if(usr == null)
                Log.d("PRUEBA", "NULO")
            else{
            Log.d("PRUEBA", usr.email)
            Log.d("PRUEBA", usr.password)
            Log.d("PRUEBA", usr.rol)
                }
        }
    }

}

