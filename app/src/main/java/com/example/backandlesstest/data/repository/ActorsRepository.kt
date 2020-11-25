package com.example.backandlesstest.data.repository

import com.example.backandlesstest.domain.models.ActorModel
import retrofit2.Response

interface ActorsRepository {
   suspend fun getActorsData(): List<ActorModel>
}