package com.example.backandlesstest.data.repository

import com.example.backandlesstest.data.apiservice.ActorsApiService
import com.example.backandlesstest.data.mappers.MapApiResponseToActorModelList
import com.example.backandlesstest.domain.models.ActorModel

class ActorsRepositoryImpl(
    private val mapper: MapApiResponseToActorModelList,
    private val actorsApiService: ActorsApiService
) : ActorsRepository {

    override suspend fun getActorsData(): List<ActorModel> {
        val list = mutableListOf<ActorModel>()

        try {
            val response = actorsApiService.getActorsData()
            if (response.isSuccessful) {
                response.body()?.let {
                    list.addAll(mapper.mapApiResponseToActorModelList(it))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }
}

