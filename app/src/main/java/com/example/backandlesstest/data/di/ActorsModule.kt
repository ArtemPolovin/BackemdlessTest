package com.example.backandlesstest.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.backandlesstest.data.apiservice.ActorsApiService
import com.example.backandlesstest.data.mappers.MapApiResponseToActorModelList
import com.example.backandlesstest.data.repository.ActorsRepository
import com.example.backandlesstest.data.repository.ActorsRepositoryImpl
import com.example.backandlesstest.domain.usecase.GetActorsDataUseCase
import com.example.backandlesstest.utils.ActorDataCache
import com.example.backandlesstest.utils.SHARE_PREF
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActorsModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideActorApiService() = ActorsApiService()

    @Provides
    @Singleton
    fun provideActorRepositoryImpl(
        mapper: MapApiResponseToActorModelList,
        apiService: ActorsApiService
    ): ActorsRepository = ActorsRepositoryImpl(mapper, apiService)

    @Provides
    fun provideMapApiResponseToActorModel() = MapApiResponseToActorModelList()

    @Provides
    fun provideGetActorsDataUseCAse(actorsRepository: ActorsRepository) =
        GetActorsDataUseCase(actorsRepository)

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(SHARE_PREF,Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideActorDataCache(
        sharePref: SharedPreferences,
        gson: Gson
    ) = ActorDataCache(sharePref,gson)

    @Provides
    @Singleton
    fun provideGson() = Gson()

}