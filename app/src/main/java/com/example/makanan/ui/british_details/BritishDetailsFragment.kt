package com.example.makanan.ui.british_details

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
import com.example.makanan.databinding.FragmentBritishDetailsBinding
import com.example.makanan.databinding.FragmentMealDetailsBinding
import com.example.makanan.ui.british.BritishViewModel
import com.example.makanan.ui.meal.MealViewModel

class BritishDetailsFragment : Fragment() {
    private val viewModel : BritishViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val binding = FragmentBritishDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.british.value?.strMeal
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_britishDetailsFragment_to_britishFragment)
        }
        return true
    }
}