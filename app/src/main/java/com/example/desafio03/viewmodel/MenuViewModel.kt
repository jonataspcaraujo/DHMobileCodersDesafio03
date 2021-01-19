package com.example.desafio03.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.example.desafio03.api.ResponseAPI
import com.example.desafio03.business.MarvelMenuBusiness
import com.example.desafio03.model.Comic
import kotlinx.coroutines.launch

class MenuViewModel: ViewModel() {

    val onResultComics: MutableLiveData<Comic> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MarvelMenuBusiness()
    }

    fun getComics() {
        viewModelScope.launch {
            when (val response = business.getComics()){
                is ResponseAPI.Success-> {
                    onResultComics.postValue(
                        response.data as Comic
                    )
                }
                is ResponseAPI.Error ->{
                    onResultFailure.postValue(response.message)
                }
            }
        }

    }


}