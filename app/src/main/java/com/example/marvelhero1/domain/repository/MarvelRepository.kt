package com.example.marvelhero1.domain.repository

import com.example.marvelhero1.domain.entity.Marvel
import retrofit2.Call

interface MarvelRepository {

    fun getMarvelList(): Call<ArrayList<Marvel>>
}