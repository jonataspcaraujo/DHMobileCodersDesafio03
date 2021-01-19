package com.example.desafio03.business

import com.example.desafio03.api.ResponseAPI
import com.example.desafio03.model.Comic
import com.example.desafio03.repository.MarvelMenuRepository

class MarvelMenuBusiness {

    private val repository by lazy {
        MarvelMenuRepository()
    }

    suspend fun getComics(): ResponseAPI {
        val response = repository.getComics()
        return if (response is ResponseAPI.Success) {
            val hqItem = response.data as Comic
            ResponseAPI.Success(hqItem)
        } else response
    }


}