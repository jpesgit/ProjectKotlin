package com.example.joaopedrosilva.projectkotlin.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.joaopedrosilva.projectkotlin.communication.WikiApi
import com.example.joaopedrosilva.projectkotlin.communication.WikiRestAPI
import com.example.joaopedrosilva.projectkotlin.data.AppDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AppModule(private val context: Context) {

    @Provides
    @AppScope
    fun providesAppContext() = context

    @Provides
    @AppScope
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-todo-db").build()

    @Provides
    @AppScope
    fun providesToDoDao(database: AppDatabase) = database.taskDao()

    @AppScope
    @Provides
    fun provideWikiApi(retrofit: Retrofit) = retrofit.create(WikiApi::class.java)

    @Provides
    @AppScope
    fun provideNewsAPI(wikiApi: WikiApi) = WikiRestAPI(wikiApi)
}