package com.example.joaopedrosilva.projectkotlin.communication


import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.ResultWiki
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by joaopedrosilva on 03/11/17.
 */
interface WikiApi {

    @GET("api.php")
    fun hitCountCheck(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String): Observable<ResultWiki>



}