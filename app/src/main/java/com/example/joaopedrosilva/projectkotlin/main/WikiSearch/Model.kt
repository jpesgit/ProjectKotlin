package com.example.joaopedrosilva.projectkotlin.main.WikiSearch


/**
 * Created by joaopedrosilva on 03/11/17.
 */

// isto nao devia ser um singleton, poe em tres classes separadas
// examplo: Result, ResultQuery, ResultQuerySearchInfo
object Model {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}