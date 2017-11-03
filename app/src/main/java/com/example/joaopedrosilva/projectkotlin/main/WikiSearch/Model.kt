package com.example.joaopedrosilva.projectkotlin.main.WikiSearch


/**
 * Created by joaopedrosilva on 03/11/17.
 */
object Model {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}