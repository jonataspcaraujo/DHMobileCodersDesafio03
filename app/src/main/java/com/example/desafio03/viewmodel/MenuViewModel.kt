package com.example.desafio03.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.example.desafio03.api.ResponseAPI
import com.example.desafio03.business.MarvelMenuBusiness
import com.example.desafio03.model.HqItem
import kotlinx.coroutines.launch

class MenuViewModel: ViewModel() {

    val onResultHqs: MutableLiveData<HqItem> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MarvelMenuBusiness()
    }

    fun getHQs() {
        viewModelScope.launch {
            when (val response = business.getHQs()){
                is ResponseAPI.Success-> {
                    onResultHqs.postValue(
                        response.data as HqItem
                    )
                }
                is ResponseAPI.Error ->{
                    onResultFailure.postValue(response.message)
                }
            }
        }

    }


}