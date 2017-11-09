package com.example.joaopedrosilva.projectkotlin.di


import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiAct
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(WikiActComponent.WikiActModule::class))
interface WikiActComponent : AndroidInjector<WikiAct> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<WikiAct>()

    @Module
    class WikiActModule
}