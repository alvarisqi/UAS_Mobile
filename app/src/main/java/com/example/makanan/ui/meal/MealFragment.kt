package com.example.makanan.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.makanan.R
import com.example.makanan.databinding.FragmentMealBinding

class MealFragment : Fragment() {

    private val viewModel: MealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMealBinding.inflate(inflater)
        viewModel.getMealList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MealAdapter(MealListener { meal ->
            viewModel.onMealClicked(meal)
            findNavController()
                .navigate(R.id.action_mealFragment_to_mealDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Meal"

        return binding.root
    }
}