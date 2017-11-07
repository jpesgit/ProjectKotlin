package com.example.joaopedrosilva.projectkotlin

import android.app.Activity
import android.app.Application
import com.example.joaopedrosilva.projectkotlin.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by joaopedrosilva on 30/10/17.
 */
class ProjectKotlinApplication : Application(), HasActivityInjector {


    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        AppComponent.build(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}