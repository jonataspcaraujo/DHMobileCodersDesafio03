package com.example.desafio03.util

class Constants {
    object APIMarvel{
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_TS_NAME = "ts"
        const val API_KEY_NAME = "apikey"
        const val API_HASH_NAME = "hash"
        const val API_PUBLIC_KEY_VALUE = "293a2b82340c11ba84ef61de4104f190"
        const val API_PRIVATE_KEY_VALUE = "9ac20bfb6075dd43cf17221a49c974478e87ded4"
        const val QUERY_FORMAT_NAME = "format"
        const val QUERY_FORMAT_VALUE = "comic"
        const val QUERY_FORMAT_TYPE_NAME = "formatType"
        const val QUERY_FORMAT_TYPE_VALUE = "comic"
        const val QUERY_ORDER_BY_NAME = "orderBy"
        const val QUERY_ORDER_BY_VALUE = "-issueNumber"
        const val QUERY_CHARACTER_NAME = "characters"
        const val QUERY_CHARACTER_VALUE = "1009718"
    }

    object Intent {
        const val KEY_COMIC_RESULT = "comics"
        const val KEY_COMIC_THUMBNAIL = "thumbnail"
    }

}