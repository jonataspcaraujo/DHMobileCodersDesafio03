package com.example.desafio03.api

import com.example.desafio03.model.Comic
import com.example.desafio03.util.Constants.Intent.KEY_COMIC_RESULT
import retrofit2.Response
import retrofit2.http.GET

interface MarvelAPI {
    @GET(KEY_COMIC_RESULT)
    suspend fun getComics(): Response<Comic>
}