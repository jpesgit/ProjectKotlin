package com.example.joaopedrosilva.projectkotlin.di

import com.example.joaopedrosilva.projectkotlin.main.ThirdActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@Subcomponent
interface ToDoSubComponent : AndroidInjector<ThirdActivity> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ThirdActivity>()
}