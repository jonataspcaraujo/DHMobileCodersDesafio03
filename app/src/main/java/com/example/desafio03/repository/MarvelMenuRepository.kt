package com.example.desafio03.repository

import com.example.desafio03.api.APIService.marvelAPI
import com.example.desafio03.api.ResponseAPI

class MarvelMenuRepository {

    suspend fun getHQs():ResponseAPI{
        return try{
            val response = marvelAPI.getHQs()
            if(response.code() == 200) {
                ResponseAPI.Success(response.body())
            } else{
                if (response.code() == 404){
                    ResponseAPI.Error("Dados não encontrados")
                } else{
                    ResponseAPI.Error("Falha no carregamento dos dados")
                }
            }
        }catch (exception: Exception){
            ResponseAPI.Error("Falha no carregamento dos dados")
        }


    }
}