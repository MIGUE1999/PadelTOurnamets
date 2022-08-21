package com.bluetooth.padeltournamets.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetooth.padeltournamets.model.entities.CourtEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.ICourtRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourtViewModel @Inject constructor(
    private val courtRepository : ICourtRepository
) : ViewModel()
{
    val getAllCourts : LiveData<List<CourtEntity>> by lazy {
        courtRepository.getAllCourts()
    }

    fun getCourtById(id:Int) : LiveData<CourtEntity> {
        return courtRepository.getCourtById(id)
    }

    fun insertCourt(court : CourtEntity){
        viewModelScope.launch(Dispatchers.IO) {
            courtRepository.insertCourt(court)
            delay(3000)
        }
    }

    fun updateCourt(court : CourtEntity){
        viewModelScope.launch(Dispatchers.IO) {
            courtRepository.updateCourt(court)
        }
    }

    fun deleteCourt(court : CourtEntity){
        viewModelScope.launch(Dispatchers.IO) {
            courtRepository.deleteCourt(court)
        }
    }

}