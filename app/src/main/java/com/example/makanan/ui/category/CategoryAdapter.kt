package com.example.makanan.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.makanan.databinding.CategoryRowBinding
import com.example.makanan.network.Category

class CategoryAdapter(private val clickListener: CategoryListener) :
    ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(DiffCallback)
{
    class CategoryViewHolder(
        var binding: CategoryRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: CategoryListener, category: Category) {
            binding.category = category
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.strCategory == newItem.strCategory
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.strCategoryDescription == newItem.strCategoryDescription &&  oldItem.strCategoryThumb== newItem.strCategoryThumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(
            CategoryRowBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(clickListener, category)
    }

}
class CategoryListener(val clickListener: (category: Category) -> Unit) {
    fun onClick(category: Category) = clickListener(category)
}