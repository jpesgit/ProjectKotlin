package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.example.joaopedrosilva.projectkotlin.communication.SearchApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.example.joaopedrosilva.projectkotlin.di.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@AppScope
@Module()
class WikiModule {
    @AppScope
    @Provides
    fun provideWikiApi(retrofit: Retrofit): WikiApi = retrofit.create(WikiApi::class.java)

    @Provides
    @AppScope
    fun provideNewsAPI(wikiApi: WikiApi): SearchApi = WikiRestAPI(wikiApi)

}