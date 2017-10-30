package com.example.joaopedrosilva.projectkotlin

import android.app.Activity
import android.app.Application
import com.example.joaopedrosilva.projectkotlin.di.AppComponent
import com.example.joaopedrosilva.projectkotlin.di.AppModule
import com.example.joaopedrosilva.projectkotlin.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by joaopedrosilva on 30/10/17.
 */
class ProjectKotlinApplication : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()

        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}