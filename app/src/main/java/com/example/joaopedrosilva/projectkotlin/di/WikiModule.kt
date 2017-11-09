package com.example.joaopedrosilva.projectkotlin.di

import android.app.Activity
import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiAct
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(WikiActComponent::class))
abstract class WikiModule {
    @Binds
    @IntoMap
    @ActivityKey(WikiAct::class)
    internal abstract fun bindWikiAct(builder: WikiActComponent.Builder): AndroidInjector.Factory<out Activity>
}