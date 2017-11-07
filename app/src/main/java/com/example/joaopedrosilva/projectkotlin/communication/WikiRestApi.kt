package com.example.joaopedrosilva.projectkotlin.communication


import com.example.joaopedrosilva.projectkotlin.main.WikiSearch.ResultWiki
import io.reactivex.Observable
import javax.inject.Inject


class WikiRestAPI @Inject constructor(private val wikiApi: WikiApi) : SearchApi {

    override fun hitCountCheck(action: String,
                               format: String,
                               list: String,
                               search: String): Observable<ResultWiki> {
        return wikiApi.hitCountCheck(action, format, list, search)
    }
}