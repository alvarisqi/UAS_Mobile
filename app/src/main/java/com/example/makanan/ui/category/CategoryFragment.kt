package com.example.makanan.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.makanan.R
import com.example.makanan.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private val viewModel: CategoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(inflater)
        viewModel.getCategoryList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CategoryAdapter(CategoryListener { category ->
            viewModel.onCategoryClicked(category)
            findNavController()
                .navigate(R.id.action_categoryFragment_to_categoryDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Categories"

        return binding.root
    }
}