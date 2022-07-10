package com.bluetooth.padeltournamets.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetooth.padeltournamets.model.entities.TorneoEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ITorneoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TorneoViewModel @Inject constructor(
    private val tournamentRepository : ITorneoRepository
) : ViewModel() {

    val tournaments : MutableState<List<TorneoEntity>> = mutableStateOf(listOf())
/*
    fun getTournaments(){
        tournaments.value = tournamentRepository.getAllTorneos()
    }
*/

    fun insertTournament(tournament : TorneoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            tournamentRepository.insertTorneo(tournament)
        }
    }
}

