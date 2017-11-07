package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.example.joaopedrosilva.projectkotlin.communication.SearchApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.example.joaopedrosilva.projectkotlin.di.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by joaopedrosilva on 06/11/17.
 */
@AppScope
@Module()
class WikiModule {
    @AppScope
    @Provides
    fun provideWikiApi(retrofit: Retrofit): WikiApi = retrofit.create(WikiApi::class.java)

    @Provides
    @Singleton
    fun provideNewsAPI(wikiApi: WikiApi): SearchApi = WikiRestAPI(wikiApi)

}