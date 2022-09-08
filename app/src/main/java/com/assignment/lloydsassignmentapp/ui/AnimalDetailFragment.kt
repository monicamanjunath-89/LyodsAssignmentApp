package com.assignment.lloydsassignmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.base.BaseFragment
import com.assignment.lloydsassignmentapp.common.Constants
import com.assignment.lloydsassignmentapp.databinding.AnimalDetailFragmentBinding
import com.assignment.lloydsassignmentapp.viewmodel.AnimalDetailViewModel
import com.bumptech.glide.Glide

class AnimalDetailFragment : BaseFragment<AnimalDetailViewModel, AnimalDetailFragmentBinding>() {

    override val viewmodel: AnimalDetailViewModel
        get() = ViewModelProvider(this)[AnimalDetailViewModel::class.java]

    override fun getViewBinding(): AnimalDetailFragmentBinding =
        AnimalDetailFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animalData = arguments?.get(Constants.ANIMAL_SELECTED) as AnimalModel
        initUi(animalData)
    }

    /**
     * Method to add data to UI
     */
    private fun initUi(animalData: AnimalModel) {
        binding.name.text = animalData.name
        binding.latinName.text = animalData.latin_name
        binding.type.text = animalData.animal_type
        binding.diet.text = animalData.diet
        binding.geoRange.text = animalData.geo_range
        binding.habitat.text = animalData.habitat
        binding.lengthMin.text = animalData.length_min.toString()
        binding.lengthMax.text = animalData.length_max.toString()
        binding.weightMin.text = animalData.weight_min.toString()
        binding.weightMax.text = animalData.weight_max.toString()
        binding.lifespan.text = animalData.lifespan.toString()
        Glide.with(binding.image.context)
            .load(animalData.image_link) // image url
            .into(binding.image)
    }
}