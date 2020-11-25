package com.example.backandlesstest.data.mappers

import com.example.backandlesstest.domain.models.ActorModel
import com.example.backandlesstest.domain.models.apimodel.ActorsResponseModel

class MapApiResponseToActorModelList {

    fun mapApiResponseToActorModelList(actorApiResponse: ActorsResponseModel): List<ActorModel> {
        return actorApiResponse.map {
            ActorModel(
                it.age.toString(),
                it.avatar,
                it.citizenship,
                it.date_of_birth,
                it.growth,
                it.name,
                it.objectId
            )
        }
    }
}