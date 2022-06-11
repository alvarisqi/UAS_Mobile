package com.example.makanan.ui.british

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.makanan.R
import com.example.makanan.databinding.FragmentBritishBinding
import com.example.makanan.databinding.FragmentMealBinding
import com.example.makanan.ui.meal.MealAdapter
import com.example.makanan.ui.meal.MealListener
import com.example.makanan.ui.meal.MealViewModel

class BritishFragment : Fragment() {
    private val viewModel: BritishViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBritishBinding.inflate(inflater)
        viewModel.getBritishList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BritishAdapter(BritishListener { british ->
            viewModel.onMealClicked(british)
            findNavController()
                .navigate(R.id.action_britishFragment_to_britishDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "British"

        return binding.root
    }
}