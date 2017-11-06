package com.example.joaopedrosilva.projectkotlin.di

import android.app.Activity
import com.example.joaopedrosilva.projectkotlin.main.ThirdActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ThirdActivityComponent::class))
abstract class ActBindModule {
    @Binds
    @IntoMap
    @ActivityKey(ThirdActivity::class)
    internal abstract fun bindThirdActivity(builder: ThirdActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}