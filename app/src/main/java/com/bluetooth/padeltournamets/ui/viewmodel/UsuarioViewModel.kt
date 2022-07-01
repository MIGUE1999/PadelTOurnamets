package com.bluetooth.padeltournamets.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IUsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val usuarioRepository : IUsuarioRepository
) : ViewModel()
{
    //LiveData porque no lo modificamos
   val allUsers: LiveData<List<UsuarioEntity>> by lazy{
       usuarioRepository.getAllUsuarios()
   }
    //MutableLiveData porque lo modificamos
    private val _isLoading: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>(false)
    }
    //Variable que coge la UI que no se puede modificar desde la UI
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun insertUsuario(){
        if(_isLoading.value == false)
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                delay(1000)
                val usr = UsuarioEntity("migue", "Mgue", "migue@gmail.com", "111111111", "203945865")
                usuarioRepository.insertUsuario(usr)
                _isLoading.postValue(false)
            }
    }
    fun deleteUsuario(usr : UsuarioEntity){
        viewModelScope.launch(Dispatchers.IO) {
            usuarioRepository.deleteUsuario(usr)
        }
    }
}

