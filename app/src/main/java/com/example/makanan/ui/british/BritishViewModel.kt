package com.example.makanan.ui.british

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanan.network.British
import com.example.makanan.network.BritishApi

import kotlinx.coroutines.launch

enum class BritishApiStatus { LOADING, ERROR, DONE }

class BritishViewModel: ViewModel() {
    private val _status = MutableLiveData<BritishApiStatus>()
    val status: LiveData<BritishApiStatus> = _status

    private val _britishs = MutableLiveData<List<British>>()
    val britishs: LiveData<List<British>> = _britishs

    private val _british = MutableLiveData<British>()
    val british: LiveData<British> = _british

    fun getBritishList() {
        viewModelScope.launch {
            _status.value = BritishApiStatus.LOADING
            try {
                _britishs.value = BritishApi.retrofitService.getBritish().await().meals
                _status.value = BritishApiStatus.DONE
            } catch (e: Exception) {
                _britishs.value = listOf()
                _status.value = BritishApiStatus.ERROR
            }
        }
    }

    fun onMealClicked(british: British) {
        _british.value = british
    }
}