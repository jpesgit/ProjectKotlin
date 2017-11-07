package com.example.joaopedrosilva.projectkotlin.di

import com.example.joaopedrosilva.projectkotlin.ProjectKotlinApplication
import dagger.Component

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@AppScope
@Component(modules = arrayOf(AppModule::class,
        ActBindModule::class,
        NetworkModule::class,
        WikiModule::class))

interface AppComponent {
    fun inject(application: ProjectKotlinApplication)

    companion object {
        fun build(app: ProjectKotlinApplication) {
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build().apply { inject(app) }

        }
    }


}