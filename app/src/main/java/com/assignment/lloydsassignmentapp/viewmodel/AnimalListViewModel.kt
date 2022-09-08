package com.assignment.lloydsassignmentapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.usecases.GetAllAnimalsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(private val getAllAnimalsUsecase: GetAllAnimalsUsecase) :
    ViewModel() {
    val resultFlow = MutableStateFlow<Resource<List<AnimalModel>>>(Resource.Loading())

    init {
        getAnimalList()
    }

    fun getAnimalList() {
       getAllAnimalsUsecase().onEach { result ->
            resultFlow.value = result
        }.launchIn(viewModelScope)
    }
}