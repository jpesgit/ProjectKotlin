package com.example.joaopedrosilva.projectkotlin.communication

import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.ResultWiki
import io.reactivex.Observable

/**
 * Created by joaopedrosilva on 06/11/17.
 */
interface SearchApi {
    fun hitCountCheck(action: String,
                      format: String,
                      list: String,
                      search: String): Observable<ResultWiki>

}