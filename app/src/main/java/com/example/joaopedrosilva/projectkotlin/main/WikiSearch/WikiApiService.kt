package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by joaopedrosilva on 03/11/17.
 */
interface WikiApiService {

    @GET("api.php")
    fun hitCountCheck(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String): Observable<ResultWiki>

    companion object {
        fun create(): WikiApiService {
            val retrofit = Retrofit.Builder()
                    .client(
                            OkHttpClient.Builder().apply {
                                addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                            }.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("https://en.wikipedia.org/w/")
                    .build()

            return retrofit.create(WikiApiService::class.java)
        }
    }

}