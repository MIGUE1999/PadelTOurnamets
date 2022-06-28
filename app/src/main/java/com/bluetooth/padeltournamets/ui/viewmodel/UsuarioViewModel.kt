package com.bluetooth.padeltournamets.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.bluetooth.padeltournamets.model.entities.UsuarioEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IUsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val usuarioRepository : IUsuarioRepository
) : ViewModel()
{
    val allUsers = usuarioRepository.getAllUsuarios().asLiveData()
    private val _isLoading: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>(false)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading

    fun insertUsuario(usr: UsuarioEntity){

        if(_isLoading.value == false)
            viewModelScope.launch {
                _isLoading.postValue(true)
                usuarioRepository.insertUsuario(usr)
                _isLoading.postValue(false)
            }
    }

    fun deleteUsuario(usr : UsuarioEntity){
        viewModelScope.launch {
            usuarioRepository.deleteUsuario(usr)
        }
    }
    fun getUsuario(id: Int) : LiveData<UsuarioEntity> {
        return usuarioRepository.getUsuario(id).asLiveData()
    }
/*
    fun getAllUsuarios(){
        viewModelScope.launch {
            usuarioRepository.getAllUsuarios().collect{ usuarios ->
                allUsers = usuarioRepository.getAllUsuarios()
                usrsEntitiesLiveData.postValue(usuarios)
            }
        }
    }
    */

}

