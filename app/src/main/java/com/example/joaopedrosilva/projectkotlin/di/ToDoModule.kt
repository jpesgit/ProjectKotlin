package com.example.joaopedrosilva.projectkotlin.di

import android.app.Activity
import com.example.joaopedrosilva.projectkotlin.main.ThirdActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@Module(subcomponents = arrayOf(ToDoSubComponent::class))
abstract class ToDoModule {

    @Binds
    @IntoMap
    @ActivityKey(ThirdActivity::class)
    internal abstract fun bindsToDoActivityInjectorFactory(builder: ToDoSubComponent.Builder): AndroidInjector.Factory<out Activity>
}