package com.example.backandlesstest.data.apiservice

import com.example.backandlesstest.domain.models.apimodel.ActorsResponseModel
import com.example.backandlesstest.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ActorsApiService {

    @GET("/F5D00840-08F8-FD7F-FF31-74B96D9B2100/67E21903-1910-4272-B32A-4CA550CB95A7/data/Person")
    suspend fun getActorsData(): Response<ActorsResponseModel>

    companion object {
        operator fun invoke(): ActorsApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .build()
                .create(ActorsApiService::class.java)
        }
    }
}