package com.example.backandlesstest.utils

import android.content.SharedPreferences
import com.example.backandlesstest.domain.models.ActorModel
import com.google.gson.Gson

class ActorDataCache(
    private val sharedPref: SharedPreferences,
    private val gson: Gson
) {

    fun saveActorId(actorId: String) {
        sharedPref.edit().putString(ACTOR_ID_KEY,actorId).apply()
    }

    fun loadActorId(): String{
        return sharedPref.getString(ACTOR_ID_KEY," ") ?: " "
    }

    fun saveActorsList(actorsList: List<ActorModel>) {

        val json = gson.toJson(actorsList)

        sharedPref.edit().putString(ACTORS_LIST, json).apply()
    }

    fun loadActorsList(): List<ActorModel> {
        val serializableObject = sharedPref.getString(ACTORS_LIST, null)
        return gson.fromJson(serializableObject,Array<ActorModel>::class.java).toList()
    }

}