package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.squareup.moshi.Json

/**
 * Created by joaopedrosilva on 06/11/17.
 */
data class QueryObj(
        @field:Json(name = "searchinfo") @Json(name = "searchinfo")
        val searchInfo: SearchInfo,
        @field:Json(name = "search") @Json(name = "search")
        val search: List<Search>
)