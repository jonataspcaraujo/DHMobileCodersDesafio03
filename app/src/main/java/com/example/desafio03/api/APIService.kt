package com.example.desafio03.api

import com.example.desafio03.util.Constants.APIMarvel.API_HASH_NAME
import com.example.desafio03.util.Constants.APIMarvel.API_KEY_NAME
import com.example.desafio03.util.Constants.APIMarvel.API_PRIVATE_KEY_VALUE
import com.example.desafio03.util.Constants.APIMarvel.API_PUBLIC_KEY_VALUE
import com.example.desafio03.util.Constants.APIMarvel.API_TS_NAME
import com.example.desafio03.util.Constants.APIMarvel.QUERY_CHARACTER_NAME
import com.example.desafio03.util.Constants.APIMarvel.QUERY_CHARACTER_VALUE
import com.example.desafio03.util.Constants.APIMarvel.QUERY_FORMAT_NAME
import com.example.desafio03.util.Constants.APIMarvel.QUERY_FORMAT_TYPE_NAME
import com.example.desafio03.util.Constants.APIMarvel.QUERY_FORMAT_TYPE_VALUE
import com.example.desafio03.util.Constants.APIMarvel.QUERY_FORMAT_VALUE
import com.example.desafio03.util.Constants.APIMarvel.QUERY_ORDER_BY_NAME
import com.example.desafio03.util.Constants.APIMarvel.QUERY_ORDER_BY_VALUE
import com.example.desafio03.util.Constants.APIMarvel.URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit


object APIService {

    val marvelAPI: MarvelAPI = getMarvelAPIClient().create(MarvelAPI::class.java)

    private fun getMarvelAPIClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(URL)
                .client(getInterceptorMarvelClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun getInterceptorMarvelClient(): OkHttpClient {

        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(logginInterceptor)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                            .build()
                    chain.proceed(newRequest)
                }.addInterceptor { chain ->
                    val timestamp = System.currentTimeMillis()
                    val url = chain.request().url.newBuilder()
                            .addQueryParameter(API_TS_NAME, timestamp.toString())
                            .addQueryParameter(API_HASH_NAME, getHash(timestamp.toString()))
                            .addQueryParameter(QUERY_FORMAT_NAME, QUERY_FORMAT_VALUE)
                            .addQueryParameter(QUERY_FORMAT_TYPE_NAME, QUERY_FORMAT_TYPE_VALUE)
                            .addQueryParameter(QUERY_CHARACTER_NAME, QUERY_CHARACTER_VALUE)
                            .addQueryParameter(QUERY_ORDER_BY_NAME, QUERY_ORDER_BY_VALUE)
                            .addQueryParameter(API_KEY_NAME, API_PUBLIC_KEY_VALUE)
                            .build()
                    val newRequest = chain.request().newBuilder().url(url).build()
                    chain.proceed(newRequest)
                }
        return interceptor.build()
    }

    private fun getHash(timestamp: String): String {
        val message = timestamp + API_PRIVATE_KEY_VALUE + API_PUBLIC_KEY_VALUE
        val messageDigest = MessageDigest.getInstance("MD5")
        return BigInteger(1, messageDigest.digest(message.toByteArray()))
                .toString(16)
                .padStart(32, '0')
    }
}