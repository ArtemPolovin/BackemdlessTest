package com.example.backandlesstest.data.di

import com.example.backandlesstest.ui.actorinfo.ActorInfoFragment
import com.example.backandlesstest.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActorsModule::class])
interface ActorsComponent {

    fun inject(homeFragment: HomeFragment)
    fun inject(actorInfoFragment: ActorInfoFragment)
}