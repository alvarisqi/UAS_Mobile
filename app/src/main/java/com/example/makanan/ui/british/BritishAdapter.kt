package com.example.makanan.ui.british

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.makanan.databinding.BritishRowBinding
import com.example.makanan.databinding.MealRowBinding
import com.example.makanan.network.British
import com.example.makanan.network.Category


class BritishAdapter(private val clickListener: BritishListener) :
    ListAdapter<British, BritishAdapter.BritishViewHolder>(DiffCallback)
{
    class BritishViewHolder(
        var binding: BritishRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: BritishListener, british: British) {
            binding.british = british
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<British>() {
        override fun areItemsTheSame(oldItem: British, newItem: British): Boolean {
            return oldItem.strMeal == newItem.strMeal
        }

        override fun areContentsTheSame(oldItem: British, newItem: British): Boolean {
            return oldItem.strMealThumb == newItem.strMealThumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BritishAdapter.BritishViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BritishAdapter.BritishViewHolder(
            BritishRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BritishAdapter.BritishViewHolder, position: Int) {
        val british = getItem(position)
        holder.bind(clickListener, british)
    }

}
class BritishListener(val clickListener: (british: British) -> Unit) {
    fun onClick(british: British) = clickListener(british)
}