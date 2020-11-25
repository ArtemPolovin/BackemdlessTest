package com.example.backandlesstest.ui.actorinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.backandlesstest.domain.models.ActorModel
import com.example.backandlesstest.utils.ActorDataCache

class ActorInfoViewModel(
    private val actorDataCache: ActorDataCache
) : ViewModel() {

    private val _actorData = MutableLiveData<ActorModel>()
    val actorData: LiveData<ActorModel> get() = _actorData

    init {
        findActorDataById()
    }


    private fun findActorDataById() {
        val actorId = actorDataCache.loadActorId()
        val actorsList = actorDataCache.loadActorsList()
        val actor = actorsList.filter { it.objectId == actorId }[0]
        _actorData.value = actor
    }

}