package com.example.joaopedrosilva.projectkotlin.di

import android.app.Activity
import com.example.joaopedrosilva.projectkotlin.main.ToDo.ToDoActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ToDoActComponent::class))
abstract class ActBindModule {
    @Binds
    @IntoMap
    @ActivityKey(ToDoActivity::class)
    internal abstract fun bindToDoActivity(builder: ToDoActComponent.Builder): AndroidInjector.Factory<out Activity>
}