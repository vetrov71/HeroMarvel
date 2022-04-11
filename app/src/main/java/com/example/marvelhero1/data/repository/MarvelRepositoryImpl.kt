package com.example.marvelhero1.data.repository

import com.example.marvelhero1.data.network.RetrofitClient
import com.example.marvelhero1.domain.entity.Marvel
import com.example.marvelhero1.domain.repository.MarvelRepository
import retrofit2.Call

class MarvelRepositoryImpl: MarvelRepository {

    private val apiInterface = RetrofitClient.create()

    override fun getMarvelList(): Call<ArrayList<Marvel>> =
        apiInterface.getMovies()
}