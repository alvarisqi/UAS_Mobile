package com.example.makanan.ui.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.makanan.databinding.MealRowBinding
import com.example.makanan.network.Category
import com.example.makanan.network.Meal

class MealAdapter(private val clickListener: MealListener) :
    ListAdapter<Meal, MealAdapter.MealViewHolder>(DiffCallback)
{
    class MealViewHolder(
        var binding: MealRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: MealListener, meal: Meal) {
            binding.meal = meal
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.strMeal == newItem.strMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.strMealThumb == newItem.strMealThumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MealViewHolder(
            MealRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(clickListener, category)
    }

}
class MealListener(val clickListener: (meal: Meal) -> Unit) {
    fun onClick(meal: Meal) = clickListener(meal)
}