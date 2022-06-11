package com.example.makanan.network

import java.io.Serializable

data class Category(val strCategory: String,
                    val strCategoryThumb: String,
                    val strCategoryDescription: String) : Serializable
data class CategoryResponse(val categories: List<Category>)

data class Meal(val strMeal: String,
                val strMealThumb: String,
                val idMeal: String) : Serializable
data class MealResponse(val meals: List<Meal>)

data class British(val strMeal: String,
                   val strMealThumb: String,
                   val idMeal: String) : Serializable
data class BritishResponse(val meals: List<British>)