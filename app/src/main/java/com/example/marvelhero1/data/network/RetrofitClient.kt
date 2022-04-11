package com.example.marvelhero1.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL =
        "https://www.simplifiedcoding.net/demos/"

    fun create(): API {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(API::class.java)
    }
}