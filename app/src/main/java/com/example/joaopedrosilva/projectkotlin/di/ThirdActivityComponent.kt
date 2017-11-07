package com.example.joaopedrosilva.projectkotlin.di

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.LayoutManager
import com.example.joaopedrosilva.projectkotlin.data.TaskDao
import com.example.joaopedrosilva.projectkotlin.main.TaskAdapter
import com.example.joaopedrosilva.projectkotlin.main.ThirdActivity
import com.example.joaopedrosilva.projectkotlin.main.ToDoPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(ThirdActivityComponent.ThirdActivityModule::class))
interface ThirdActivityComponent : AndroidInjector<ThirdActivity> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ThirdActivity>()

    @Module
    class ThirdActivityModule{
        @Provides
        @ActivityScope
        fun providePresenter(
                taskDao: TaskDao,
                act: ThirdActivity
        ) = ToDoPresenter(taskDao, act)

        @Provides
        @ActivityScope
        fun provideLayoutManager(act: ThirdActivity): LayoutManager = LinearLayoutManager(act, LinearLayoutManager.VERTICAL, false)

        @Provides
        @ActivityScope
        fun provideTaskAdapter() = TaskAdapter()
    }
}