package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.squareup.moshi.Json

/**
 * Created by joaopedrosilva on 06/11/17.
 */
data class Search(
        @field:Json(name = "title") @Json(name = "title")
        val title: String,
        @field:Json(name = "pageid") @Json(name = "pageid")
        val pageid: Int,
        @field:Json(name = "snippet") @Json(name = "snippet")
        val snippet: String,
        @field:Json(name = "timestamp") @Json(name = "timestamp")
        val timestamp: String

)