package com.bluetooth.padeltournamets.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository : IUserRepository
) : ViewModel()
{
    val emailUser = mutableStateOf("")
    val nameUser = mutableStateOf("")
    val surnameUser = mutableStateOf("")
    val passwordUser = mutableStateOf("")
    val tlfUser = mutableStateOf("")




    val getAllUsers : LiveData<List<UserEntity>> by lazy {
        userRepository.getAllUsers()
    }

    fun getUserById(id:Int) : LiveData<UserEntity>{
        return  userRepository.getUser(id)
    }

    fun insertUser(user : UserEntity){
            viewModelScope.launch(Dispatchers.IO) {
                userRepository.insertUser(user)
                delay(3000)
            }
    }

    fun deleteUser(usr : UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(usr)
        }
    }

    fun updateUser(user : UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
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

}

