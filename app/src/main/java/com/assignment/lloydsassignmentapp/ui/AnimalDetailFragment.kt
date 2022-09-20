package com.assignment.lloydsassignmentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.common.Constants
import com.assignment.lloydsassignmentapp.databinding.AnimalDetailFragmentBinding
import com.bumptech.glide.Glide

class AnimalDetailFragment : Fragment() {

    private lateinit var viewBinding: AnimalDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewBinding = AnimalDetailFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animalData = arguments?.get(Constants.ANIMAL_SELECTED) as AnimalModel
        initUi(animalData)
    }

    /**
     * Method to add data to UI
     */
    private fun initUi(animalData: AnimalModel) {
        with(viewBinding) {
            name.text = animalData.name
            latinName.text = animalData.latinName
            type.text = animalData.animalType
            diet.text = animalData.diet
            geoRange.text = animalData.geoRange
            habitat.text = animalData.habitat
            lengthMin.text = animalData.lengthMin.toString()
            lengthMax.text = animalData.lengthMax.toString()
            weightMin.text = animalData.weightMin.toString()
            weightMax.text = animalData.weightMax.toString()
            lifespan.text = animalData.lifespan.toString()
            Glide.with(image.context)
                .load(animalData.imageLink) // image url
                .into(image)
        }
    }
}