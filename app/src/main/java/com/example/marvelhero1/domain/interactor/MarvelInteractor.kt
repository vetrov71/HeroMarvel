package com.example.marvelhero1.domain.interactor

import com.example.marvelhero1.domain.entity.Marvel
import retrofit2.Call

interface MarvelInteractor {

    fun getMarvelList(): Call<ArrayList<Marvel>>
}