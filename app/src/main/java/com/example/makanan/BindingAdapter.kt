package com.example.makanan

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.makanan.network.British
import com.example.makanan.network.Category
import com.example.makanan.network.Meal
import com.example.makanan.ui.british.BritishAdapter
import com.example.makanan.ui.british.BritishApiStatus
import com.example.makanan.ui.category.CategoryAdapter
import com.example.makanan.ui.category.CategoryApiStatus
import com.example.makanan.ui.meal.MealAdapter
import com.example.makanan.ui.meal.MealApiStatus

@BindingAdapter("listData1")
fun bindRecyclerViews(recyclerView: RecyclerView, data: List<Category>?){
    val adapter = recyclerView.adapter as CategoryAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData2")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Meal>?){
    val adapter = recyclerView.adapter as MealAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData3")
fun bindRecyclerViewz(recyclerView: RecyclerView, data: List<British>?){
    val adapter = recyclerView.adapter as BritishAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let{
        Glide.with(imgView.context)
            .load(it)
            .apply(
                RequestOptions()
            )
            .into(imgView)
    }
}

@BindingAdapter("apiStatus1")
fun bindStatus(statusImageView: ImageView, status: CategoryApiStatus?) {
    when (status) {
        CategoryApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        CategoryApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        CategoryApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus2")
fun bindStatus(statusImageView: ImageView, status: MealApiStatus?) {
    when (status) {
        MealApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        MealApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        MealApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus3")
fun bindStatus(statusImageView: ImageView, status: BritishApiStatus?) {
    when (status) {
        BritishApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        BritishApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        BritishApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}