package com.example.marvelhero1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("marvel")
    fun getMovies(): Call<ArrayList<Marvel>>

    companion object{
        private const val BASE_URL =
            "https://www.simplifiedcoding.net/demos/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory
                    .create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}
