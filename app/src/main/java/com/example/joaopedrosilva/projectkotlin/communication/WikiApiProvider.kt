package com.example.joaopedrosilva.projectkotlin.communication

interface WikiApiProvider{
    fun provideWikiRestApi(): WikiRestAPI
}