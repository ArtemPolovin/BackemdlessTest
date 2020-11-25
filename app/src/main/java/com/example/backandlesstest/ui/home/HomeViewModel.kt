package com.example.backandlesstest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.backandlesstest.domain.models.ActorModel
import com.example.backandlesstest.domain.usecase.GetActorsDataUseCase
import com.example.backandlesstest.utils.ActorDataCache
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getActorsDataUseCase: GetActorsDataUseCase,
    private val actorDataCache: ActorDataCache
) : ViewModel() {

    private val _actorsDataList = MutableLiveData<List<ActorModel>>()
    val actorsDataList: LiveData<List<ActorModel>> get() = _actorsDataList

    init {
        getActorsData()
    }

    private fun getActorsData() {
        viewModelScope.launch {
            val actorsList = getActorsDataUseCase()
            _actorsDataList.value = actorsList
            actorDataCache.saveActorsList(actorsList)
        }
    }

    fun chosenActor(actorId: String) {
        saveActorId(actorId)
    }

    private fun saveActorId(actorId: String) {
        actorDataCache.saveActorId(actorId)
    }


}