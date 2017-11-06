package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import com.squareup.moshi.Json

/**
 * Created by joaopedrosilva on 06/11/17.
 */
data class SearchInfo(
        @field:Json(name = "totalhits") @Json(name = "totalhits")
        val totalHits: Int
)