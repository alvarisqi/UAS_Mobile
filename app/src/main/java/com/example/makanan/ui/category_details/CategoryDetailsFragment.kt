package com.example.makanan.ui.category_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.makanan.R
import com.example.makanan.databinding.FragmentCategoryBinding
import com.example.makanan.databinding.FragmentCategoryDetailsBinding
import com.example.makanan.ui.category.CategoryViewModel

class CategoryDetailsFragment : Fragment() {
    private val viewModel : CategoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val binding = FragmentCategoryDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.category.value?.strCategory
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_categoryDetailsFragment_to_categoryFragment)
        }
        return true
    }
}