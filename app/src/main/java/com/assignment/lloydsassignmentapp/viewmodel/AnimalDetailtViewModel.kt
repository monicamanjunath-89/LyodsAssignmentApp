package com.assignment.lloydsassignmentapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.usecases.GetAnimalDetailsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AnimalDetailtViewModel @Inject constructor(private val getAnimalDetailUsecase: GetAnimalDetailsUsecase) :
    ViewModel() {
    val _resultFlow = MutableStateFlow<Resource<AnimalModel>>(Resource.Loading())
    val resultFlow = _resultFlow.asStateFlow()

    fun getAnimalDetail(selectedItem: Int) {
        getAnimalDetailUsecase(selectedItem).onEach { result ->
            _resultFlow.value = result
        }.launchIn(viewModelScope)
    }
}