package com.bluetooth.padeltournamets.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.TournamentEntity
import com.bluetooth.padeltournamets.model.entities.UserEntity
import com.bluetooth.padeltournamets.model.entities.relations.OrganizatorWithTournaments
import com.bluetooth.padeltournamets.model.repository.interfaces.IOrganizatorRepository
import com.bluetooth.padeltournamets.utilities.session.LoginPref
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


    val _org = MutableLiveData<OrganizatorEntity>()
    val org: LiveData<OrganizatorEntity>
        get() = _org


    val _organizatorsTournaments = MutableLiveData<List<OrganizatorWithTournaments>>()
    val organizatorsTournaments: LiveData<List<OrganizatorWithTournaments>>
        get() = _organizatorsTournaments



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

    fun getOrganizatorByUserId(user: UserEntity, session: LoginPref){
        viewModelScope.launch(Dispatchers.IO) {
            val organizator = organizatorRepository.getOrganizatorByUserId(user.id)
            Log.d("OrgViewModel", "Organizator: " + organizator.id + organizator.clubName)
            _org.postValue(organizator)
            session.createLoginSession(user.id,user.nombre, user.email, user.rol, organizator.id.toString())
        }
    }

    fun getOrganizatorsTournaments(organizatorId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            var orgTournaments = organizatorRepository.getOrganizatorWithTournaments(organizatorId)
            Log.d("FIN", "ORGTOURNAMENTS:" + orgTournaments.toString())
            _organizatorsTournaments.postValue(orgTournaments)
        }
    }




}