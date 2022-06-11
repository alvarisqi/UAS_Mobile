package com.example.makanan.ui.category

import androidx.lifecycle.*
import com.example.makanan.network.Category
import com.example.makanan.network.CategoryApi
import kotlinx.coroutines.launch

enum class CategoryApiStatus { LOADING, ERROR, DONE }

class CategoryViewModel: ViewModel() {
    private val _status = MutableLiveData<CategoryApiStatus>()
    val status: LiveData<CategoryApiStatus> = _status

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    private val _category = MutableLiveData<Category>()
    val category: LiveData<Category> = _category

    fun getCategoryList() {
        viewModelScope.launch {
            _status.value = CategoryApiStatus.LOADING
            try {
                _categories.value = CategoryApi.retrofitService.getCategory().await().categories
                _status.value = CategoryApiStatus.DONE
            } catch (e: Exception) {
                _categories.value = listOf()
                _status.value = CategoryApiStatus.ERROR
            }
        }
    }

    fun onCategoryClicked(category: Category) {
        _category.value = category
    }
}