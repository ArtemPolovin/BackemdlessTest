package com.example.backandlesstest.ui.actorinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.backandlesstest.utils.ActorDataCache
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ActorInfoFactory @Inject constructor(
    private val actorDataCache: ActorDataCache
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActorInfoViewModel::class.java)) {
            return ActorInfoViewModel(actorDataCache) as T
        }
        throw IllegalArgumentException("The ViewModel was not found")
    }

}