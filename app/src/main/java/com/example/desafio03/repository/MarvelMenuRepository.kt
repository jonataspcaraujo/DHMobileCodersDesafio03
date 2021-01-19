package com.example.desafio03.repository

import com.example.desafio03.api.APIService.marvelAPI
import com.example.desafio03.api.ResponseAPI

class MarvelMenuRepository {

    suspend fun getComics():ResponseAPI{
        return try{
            val response = marvelAPI.getComics()

            if(response.code() == 200) {
                ResponseAPI.Success(response.body())
            }else if (response.isSuccessful) {
                ResponseAPI.Success(response.body())
            } else{
                if (response.code() == 404){
                    ResponseAPI.Error("Dados não disponíveis. Erro: 404 ${response.code()}")
                } else{
                    ResponseAPI.Error("Dados não disponíveis. Erro: ${response.code()}")
                }
            }
        }catch (exception: Exception){
            ResponseAPI.Error("Falha no carregamento dos dados")
        }


    }
}