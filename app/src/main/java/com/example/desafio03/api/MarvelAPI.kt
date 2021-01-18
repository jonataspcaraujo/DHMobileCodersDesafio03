package com.example.desafio03.api

import com.example.desafio03.model.HqItem
import retrofit2.Response
import retrofit2.http.GET

interface MarvelAPI {
    @GET("HQs")
    suspend fun getHQs(): Response<HqItem>
}