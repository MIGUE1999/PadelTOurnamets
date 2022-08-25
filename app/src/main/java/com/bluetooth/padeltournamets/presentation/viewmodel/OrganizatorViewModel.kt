package com.bluetooth.padeltournamets.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.repository.interfaces.IOrganizatorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizatorViewModel @Inject constructor(
    private val organizatorRepository : IOrganizatorRepository
) : ViewModel()
{
    val cif = mutableStateOf("")
    val clubName = mutableStateOf("")
    val bankAccount = mutableStateOf("")

    val getAllOrganizators : LiveData<List<OrganizatorEntity>> by lazy {
        organizatorRepository.getAllOrganizators()
    }

    fun getOrganzatorById(id:Int) : LiveData<OrganizatorEntity> {
        return  organizatorRepository.getOrganizatorById(id)
    }

    fun insertOrganizator(organizator : OrganizatorEntity){
        viewModelScope.launch(Dispatchers.IO) {
            organizatorRepository.insertOrganizator(organizator)
        }
    }

    fun deleteOrganizator(organizator : OrganizatorEntity){
        viewModelScope.launch(Dispatchers.IO) {
            organizatorRepository.deleteOrganizator(organizator)
        }
    }

    fun updateOrganizator(organizator : OrganizatorEntity){
        viewModelScope.launch(Dispatchers.IO) {
            organizatorRepository.updateOrganizator(organizator)
        }
    }

    fun onCifChanged(cf:String){
        cif.value = cf
    }

    fun onClubNameChanged(cn:String){
        clubName.value = cn
    }

    fun onBankAccountChanged(bankAcc:String){
        bankAccount.value = bankAcc
    }

}