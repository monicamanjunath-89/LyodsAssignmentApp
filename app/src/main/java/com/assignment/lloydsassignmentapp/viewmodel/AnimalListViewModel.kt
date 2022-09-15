package com.assignment.lloydsassignmentapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.usecases.GetAllAnimalsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(private val getAllAnimalsUsecase: GetAllAnimalsUsecase) :
    ViewModel() {
    val _resultFlow = MutableStateFlow<Resource<List<AnimalModel>>>(Resource.Loading())
    val resultFlow = _resultFlow.asStateFlow()

    init {
        getAnimalList()
    }

    fun getAnimalList() {
       getAllAnimalsUsecase().onEach { result ->
            _resultFlow.value = result
        }.launchIn(viewModelScope)
    }
}