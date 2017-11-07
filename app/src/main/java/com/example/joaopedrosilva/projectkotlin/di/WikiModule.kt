package com.example.joaopedrosilva.projectkotlin.di

import android.app.Activity
import com.example.joaopedrosilva.projectkotlin.main.SecondActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(SecondActivityComponent::class))
abstract class WikiModule {
    @Binds
    @IntoMap
    @ActivityKey(SecondActivity::class)
    internal abstract fun bindSecondActivity(builder: SecondActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}