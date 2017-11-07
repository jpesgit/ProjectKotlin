package com.example.joaopedrosilva.projectkotlin.di


import com.example.joaopedrosilva.projectkotlin.main.SecondActivity
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(SecondActivityComponent.SecondActivityModule::class))
interface SecondActivityComponent : AndroidInjector<SecondActivity> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<SecondActivity>()

    @Module
    class SecondActivityModule
}