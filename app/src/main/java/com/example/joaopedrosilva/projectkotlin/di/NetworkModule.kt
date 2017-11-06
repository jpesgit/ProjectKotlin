package com.example.joaopedrosilva.projectkotlin.di

import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by joaopedrosilva on 06/11/17.
 */
@Suppress("ConstantConditionIf")
@Module
class NetworkModule {
    @Provides
    @AppScope
    fun provideProzisApiCommon(): WikiApiService {
        val retrofit = Retrofit.Builder()
                .client(
                        OkHttpClient.Builder().apply {
                            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        }.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://en.wikipedia.org/w/")
                .build()

        return retrofit.create(WikiApiService::class.java)
    }

}
