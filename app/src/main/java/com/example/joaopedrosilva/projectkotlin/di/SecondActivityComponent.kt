package com.example.joaopedrosilva.projectkotlin.di


import com.example.joaopedrosilva.projectkotlin.communication.WikiApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.example.joaopedrosilva.projectkotlin.main.SecondActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import retrofit2.Retrofit

@ActivityScope
@Subcomponent(modules = arrayOf(SecondActivityComponent.SecondActivityModule::class))
interface SecondActivityComponent : AndroidInjector<SecondActivity> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<SecondActivity>()

    @Module
    class SecondActivityModule {
        @ActivityScope
        @Provides
        fun provideWikiApi(retrofit: Retrofit) = retrofit.create(WikiApi::class.java)

        @Provides
        @ActivityScope
        fun provideNewsAPI(wikiApi: WikiApi) = WikiRestAPI(wikiApi)

    }

}