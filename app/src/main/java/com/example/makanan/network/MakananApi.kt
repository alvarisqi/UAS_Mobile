package com.example.makanan.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CategoryApiService{
    @GET("categories.php/")
    fun getCategory(): Deferred<CategoryResponse>
}

interface MealApiService{
    @GET("filter.php?a=Canadian")
    fun getMeal(): Deferred<MealResponse>
}

interface BritishApiService{
    @GET("filter.php?a=British")
    fun getBritish(): Deferred<BritishResponse>
}

object CategoryApi{
    val retrofitService : CategoryApiService by lazy {
        retrofit.create(CategoryApiService::class.java)
    }
}

object MealApi{
    val retrofitService : MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
}

object BritishApi{
    val retrofitService : BritishApiService by lazy {
        retrofit.create(BritishApiService::class.java)
    }
}