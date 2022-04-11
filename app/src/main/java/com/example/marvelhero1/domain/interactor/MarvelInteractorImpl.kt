package com.example.marvelhero1.domain.interactor

import com.example.marvelhero1.data.repository.MarvelRepositoryImpl
import com.example.marvelhero1.domain.entity.Marvel
import com.example.marvelhero1.domain.repository.MarvelRepository
import retrofit2.Call

class MarvelInteractorImpl: MarvelInteractor {

    private val repository: MarvelRepository = MarvelRepositoryImpl()

    override fun getMarvelList(): Call<ArrayList<Marvel>> =
        repository.getMarvelList()
}