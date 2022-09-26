package com.assignment.lloydsassignmentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.base.BaseFragment
import com.assignment.lloydsassignmentapp.common.Constants
import com.assignment.lloydsassignmentapp.databinding.AnimalDetailFragmentBinding
import com.assignment.lloydsassignmentapp.viewmodel.AnimalDetailtViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimalDetailFragment : BaseFragment<AnimalDetailtViewModel, AnimalDetailFragmentBinding>() {

    private lateinit var viewBinding: AnimalDetailFragmentBinding

    override val viewmodel: AnimalDetailtViewModel by activityViewModels()

    override fun getViewBinding(): AnimalDetailFragmentBinding =
        AnimalDetailFragmentBinding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = AnimalDetailFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var selectedItem = arguments?.getInt(Constants.ANIMAL_SELECTED)

        selectedItem?.let { viewmodel.getAnimalDetail(it) }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.resultFlow.collect {
                    initUi(it)
                }
            }
        }

    }

    /**
     * Method to add data to UI
     */
    private fun initUi(result: Resource<AnimalModel>) {
        when (result) {
            is Resource.Success -> {
                result.data?.let {
                    with(viewBinding) {
                        name.text = it.name
                        latinName.text = it.latinName
                        type.text = it.animalType
                        diet.text = it.diet
                        geoRange.text = it.geoRange
                        habitat.text = it.habitat
                        lengthMin.text = it.lengthMin.toString()
                        lengthMax.text = it.lengthMax.toString()
                        weightMin.text = it.weightMin.toString()
                        weightMax.text = it.weightMax.toString()
                        lifespan.text = it.lifespan.toString()
                        Glide.with(image.context)
                            .load(it.imageLink) // image url
                            .into(image)
                    }
                }
            }
        }

    }
}