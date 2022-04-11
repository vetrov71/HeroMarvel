package com.example.marvelhero1.data.network

import com.example.marvelhero1.domain.entity.Marvel
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("marvel")
    fun getMovies(): Call<ArrayList<Marvel>>
}
