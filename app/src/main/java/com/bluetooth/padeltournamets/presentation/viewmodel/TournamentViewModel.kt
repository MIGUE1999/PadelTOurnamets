package com.bluetooth.padeltournamets.presentation.viewmodel

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ITournamentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TournamentViewModel @Inject constructor(
    private val tournamentRepository : ITournamentRepository
) : ViewModel()
{
    val nameTournament = mutableStateOf("")
    val priceTournament = mutableStateOf("")
    val inscriptionCost = mutableStateOf("")
    val category = mutableStateOf("")
    val dateIni = mutableStateOf("")
    val dateFin = mutableStateOf("")
    val dateLimit = mutableStateOf("")
    val cartel = mutableStateOf<Bitmap?>(null)
    var touchedTournament : TournamentEntity? = null

    val getAllTournaments : LiveData<List<TournamentEntity>> by lazy {
        tournamentRepository.getAllTorneos()
    }

    fun getTournamentById(id:Int) : LiveData<TournamentEntity>{
        return  tournamentRepository.getTorneoById(id)
    }

    fun insertTournament(tournament : TournamentEntity){
        viewModelScope.launch(Dispatchers.IO) {
            tournamentRepository.insertTorneo(tournament)
            delay(3000)
        }
    }

    fun updateTournament(tournament : TournamentEntity){
        viewModelScope.launch(Dispatchers.IO) {
            tournamentRepository.updateTorneo(tournament)
        }
    }

    fun deleteTournament(tournament : TournamentEntity){
        viewModelScope.launch(Dispatchers.IO) {
            tournamentRepository.deleteTorneo(tournament)
        }
    }
/*
    fun deleteTournaments(tournaments : List<TournamentEntity>){
        viewModelScope.launch(Dispatchers.IO) {
            tournamentRepository.deleteTorneos(tournaments)
        }
    }
*/
    fun onNameChanged(name:String){
        nameTournament.value = name
    }

    fun onPriceChanged(price:String){
        priceTournament.value = price
    }

    fun onInscriptionCostChanged(insCost:String){
        inscriptionCost.value = insCost
    }

    fun onCategoryChanged(category:String){
        this.category.value = category
    }

    fun onDateInitChanged(dateInit : String){
        this.dateIni.value = dateInit
    }

    fun onDateFinChanged(dateFin : String){
        this.dateFin.value = dateFin
    }

    fun onDateLimitChanged(dateLimit : String){
        this.dateLimit.value = dateLimit
    }

    fun onCartelChanged(img: Bitmap?){
        this.cartel.value = img
    }

    fun onActualTournamentChanged(actualTournament : TournamentEntity){
        this.touchedTournament = actualTournament
    }

    fun getTournamentAtributes(tournament : TournamentEntity){
        onNameChanged(tournament.nombre)
        onPriceChanged(tournament.premio)
        onInscriptionCostChanged(tournament.precioInscripcion)
        onCategoryChanged(tournament.categoria)
        onDateInitChanged(tournament.fechaInicio)
        onDateFinChanged(tournament.fechaFin)
        onDateLimitChanged(tournament.fechaLimiteInscripcion)
        if(tournament.cartel != null)
            onCartelChanged(tournament.cartel)

    }

    fun clearTournamentForm(){
        onNameChanged("")
        onPriceChanged("")
        onInscriptionCostChanged("")
        onCategoryChanged("")
        onDateInitChanged("")
        onDateFinChanged("")
        onDateLimitChanged("")
        onCartelChanged(null)
        touchedTournament = null
    }
}


