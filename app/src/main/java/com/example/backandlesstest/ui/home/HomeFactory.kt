package com.example.backandlesstest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.backandlesstest.domain.usecase.GetActorsDataUseCase
import com.example.backandlesstest.utils.ActorDataCache
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class HomeFactory @Inject constructor(
    private val getActorsDataUseCase: GetActorsDataUseCase,
    private val actorDataCache: ActorDataCache
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(getActorsDataUseCase,actorDataCache) as T
        }
        throw IllegalArgumentException("the ViewModel was not found")
    }
}