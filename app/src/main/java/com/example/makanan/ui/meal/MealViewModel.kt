package com.example.makanan.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanan.network.Meal
import com.example.makanan.network.MealApi
import kotlinx.coroutines.launch

enum class MealApiStatus { LOADING, ERROR, DONE }

class MealViewModel: ViewModel() {
    private val _status = MutableLiveData<MealApiStatus>()
    val status: LiveData<MealApiStatus> = _status

    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals

    private val _meal = MutableLiveData<Meal>()
    val meal: LiveData<Meal> = _meal

    fun getMealList() {
        viewModelScope.launch {
            _status.value = MealApiStatus.LOADING
            try {
                _meals.value = MealApi.retrofitService.getMeal().await().meals
                _status.value = MealApiStatus.DONE
            } catch (e: Exception) {
                _meals.value = listOf()
                _status.value = MealApiStatus.ERROR
            }
        }
    }

    fun onMealClicked(meal: Meal) {
        _meal.value = meal
    }
}