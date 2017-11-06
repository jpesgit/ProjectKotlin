package com.example.joaopedrosilva.projectkotlin.communication

import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.ResultWiki
import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.WikiApiService
import io.reactivex.Observable

/**
 * Created by joaopedrosilva on 06/11/17.
 */
open class MainNetworkInteractor(
        private val apiService: WikiApiService
) {
    fun hitCountCheck(it: String): Observable<ResultWiki>
            = apiService.hitCountCheck("query", "json", "search", it)

}