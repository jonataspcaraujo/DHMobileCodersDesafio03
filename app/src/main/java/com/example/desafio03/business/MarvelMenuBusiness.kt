package com.example.desafio03.business

import com.example.desafio03.api.ResponseAPI
import com.example.desafio03.model.HqItem
import com.example.desafio03.repository.MarvelMenuRepository

class MarvelMenuBusiness {

    private val repository by lazy {
        MarvelMenuRepository()
    }

    suspend fun getHQs(): ResponseAPI {
        val response = repository.getHQs()
        return if (response is ResponseAPI.Success) {
            val hqItem = response.data as HqItem
            ResponseAPI.Success(hqItem)
        } else response
    }


}