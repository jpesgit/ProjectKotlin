package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.squareup.moshi.Json


/**
 * Created by joaopedrosilva on 03/11/17.
 */


data class ResultWiki(
        @field:Json(name = "query") @Json(name = "query")
        val query: QueryObj
)