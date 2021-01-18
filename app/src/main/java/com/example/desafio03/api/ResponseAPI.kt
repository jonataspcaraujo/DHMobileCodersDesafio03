package com.example.desafio03.api

open class ResponseAPI {
    class Success(val data: Any?) : ResponseAPI()
    class Error(val message: String) : ResponseAPI()
}