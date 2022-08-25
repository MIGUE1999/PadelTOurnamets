package com.bluetooth.padeltournamets.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetooth.padeltournamets.model.entities.PlayerEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IPlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val playerRepository : IPlayerRepository
) : ViewModel()
{
    val nickname = mutableStateOf("")





    val getAllPlayers : LiveData<List<PlayerEntity>> by lazy {
        playerRepository.getAllPlayers()
    }

    fun getPlayerById(id:Int) : LiveData<PlayerEntity> {
        return  playerRepository.getPlayerById(id)
    }

    fun insertPlayer(player : PlayerEntity){
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.insertPlayer(player)
        }
    }

    fun deletePlayer(player : PlayerEntity){
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.deletePlayer(player)
        }
    }

    fun updatePlayer(player : PlayerEntity){
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.updatePlayer(player)
        }
    }

    fun onNicknameChanged(nick:String){
        nickname.value = nick
    }

}