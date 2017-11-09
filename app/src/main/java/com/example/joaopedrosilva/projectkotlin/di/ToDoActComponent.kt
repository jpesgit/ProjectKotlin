package com.example.joaopedrosilva.projectkotlin.di

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.LayoutManager
import com.example.joaopedrosilva.projectkotlin.data.TaskDao
import com.example.joaopedrosilva.projectkotlin.main.ToDo.ToDoActivity
import com.example.joaopedrosilva.projectkotlin.main.ToDo.ToDoAdapter
import com.example.joaopedrosilva.projectkotlin.main.ToDo.ToDoPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(ToDoActComponent.ToDoActModule::class))
interface ToDoActComponent : AndroidInjector<ToDoActivity> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ToDoActivity>()

    @Module
    class ToDoActModule {
        @Provides
        @ActivityScope
        fun providePresenter(
                taskDao: TaskDao,
                act: ToDoActivity
        ) = ToDoPresenter(taskDao, act)
        @Provides
        @ActivityScope
        fun provideLayoutManager(act: ToDoActivity): LayoutManager = LinearLayoutManager(act, LinearLayoutManager.VERTICAL, false)

        @Provides
        @ActivityScope
        fun provideToDoAdapter() = ToDoAdapter()
    }
}