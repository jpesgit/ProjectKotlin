package com.example.joaopedrosilva.projectkotlin.di

import com.example.joaopedrosilva.projectkotlin.ProjectKotlinApplication
import dagger.Component

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@Component(modules = arrayOf(AppModule::class,
        ToDoModule::class))
interface AppComponent {

    fun inject(application: ProjectKotlinApplication)
}