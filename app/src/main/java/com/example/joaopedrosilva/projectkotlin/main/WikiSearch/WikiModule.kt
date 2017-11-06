package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.example.joaopedrosilva.projectkotlin.communication.MainNetworkInteractor
import com.example.joaopedrosilva.projectkotlin.di.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by joaopedrosilva on 06/11/17.
 */
@AppScope
@Module()
class WikiModule {
    @AppScope
    @Provides
    fun provideInteractor(apiService: WikiApiService)
            = MainNetworkInteractor(apiService)


}