package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.squareup.moshi.Json


/**
 * Created by joaopedrosilva on 03/11/17.
 */

// isto nao devia ser um singleton, poe em tres classes separadas
// examplo: Result, ResultQuery, ResultQuerySearchInfo
data class ResultWiki(
        @field:Json(name = "query") @Json(name = "query")
        val query: QueryObj
)