package com.bluetooth.padeltournamets.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bluetooth.padeltournamets.model.repository.interfaces.IUsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel



import javax.inject.Inject

@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val usuarioRepository : IUsuarioRepository
) : ViewModel()
{
    private val usrRep = usuarioRepository.getAllUsuarios()

    fun getUsuarios() : String{
        Log.d("UserViewModel", "GetUsuarios")
        return "HOLA"
    }
}

