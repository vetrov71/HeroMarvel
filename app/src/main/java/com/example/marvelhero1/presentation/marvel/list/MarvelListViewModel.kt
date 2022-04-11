package com.example.marvelhero1.presentation.marvel.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelhero1.domain.entity.Marvel
import com.example.marvelhero1.domain.interactor.MarvelInteractor
import com.example.marvelhero1.domain.interactor.MarvelInteractorImpl
import retrofit2.Call
import retrofit2.Response

class MarvelListViewModel: ViewModel() {

    private val interactor: MarvelInteractor = MarvelInteractorImpl()

    val marvelListLiveData = MutableLiveData<ArrayList<Marvel>>()
    val errorLiveData = MutableLiveData<String>()

    init {
        getMarvels()
    }

    private fun getMarvels() {
        interactor.getMarvelList().enqueue(object :
            retrofit2.Callback<ArrayList<Marvel>> {
            override fun onResponse(
                call: Call<ArrayList<Marvel>>?,
                response: Response<ArrayList<Marvel>>?
            ) {
                if (response?.body() != null)
                    marvelListLiveData.value = response.body()
            }

            override fun onFailure(
                call: Call<ArrayList<Marvel>>,
                t: Throwable
            ) {
                errorLiveData.value = t.localizedMessage
                Log.d("TAG", "onFailure: $t")
            }
        })
    }
}