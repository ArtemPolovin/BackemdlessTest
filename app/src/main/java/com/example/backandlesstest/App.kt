package com.example.backandlesstest

import android.app.Application
import com.example.backandlesstest.data.di.ActorsComponent
import com.example.backandlesstest.data.di.ActorsModule
import com.example.backandlesstest.data.di.DaggerActorsComponent
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var actorComponent: ActorsComponent

    override fun onCreate() {
        super.onCreate()
        actorComponent = DaggerActorsComponent.builder()
            .actorsModule(ActorsModule(applicationContext)).build()
    }

}