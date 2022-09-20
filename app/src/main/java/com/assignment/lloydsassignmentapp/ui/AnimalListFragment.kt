package com.assignment.lloydsassignmentapp.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.R
import com.assignment.lloydsassignmentapp.adapter.AnimalListAdapter
import com.assignment.lloydsassignmentapp.base.BaseFragment
import com.assignment.lloydsassignmentapp.common.ListItemClickListener
import com.assignment.lloydsassignmentapp.common.Constants.ANIMAL_SELECTED
import com.assignment.lloydsassignmentapp.databinding.AnimalListFragmentBinding
import com.assignment.lloydsassignmentapp.viewmodel.AnimalListViewModel
import kotlinx.coroutines.launch


class AnimalListFragment : BaseFragment<AnimalListViewModel, AnimalListFragmentBinding>(),
    ListItemClickListener {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    override val viewmodel: AnimalListViewModel
        get() = ViewModelProvider(requireActivity())[AnimalListViewModel::class.java]

    override fun getViewBinding(): AnimalListFragmentBinding =
        AnimalListFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {  animallist.layoutManager = LinearLayoutManager(context)}

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.resultFlow.collect {
                    setUpUi(it)
                }
            }
        }
    }

    /**
     * Method to setup Ui based on the data retrieved from API
     */
    private fun setUpUi(result: Resource<List<AnimalModel>>) {
        when (result) {
            is Resource.Success -> {
                result.data?.let {
                    val adapter = AnimalListAdapter(this, it)
                    with(binding) {
                        animallist.adapter = adapter
                        progressBar.visibility = View.GONE
                        errorText.visibility = View.GONE
                        animallist.visibility = View.VISIBLE
                    }

                }
            }
            is Resource.Error -> {
                with(binding) {
                    progressBar.visibility = View.GONE
                    errorText.visibility = View.VISIBLE
                    errorText.text = result.message
                    animallist.visibility = View.GONE
                }
            }
            is Resource.Loading -> {
                with(binding) {
                    progressBar.visibility = View.VISIBLE
                    errorText.visibility = View.GONE
                    animallist.visibility = View.GONE
                }
            }
        }
    }

    override fun onListItemClickListener(item: AnimalModel) {
        val bundle = bundleOf(ANIMAL_SELECTED to item)
        findNavController().navigate(R.id.action_AnimalListFragment_to_AnimalDetailFragment, bundle)
    }

}