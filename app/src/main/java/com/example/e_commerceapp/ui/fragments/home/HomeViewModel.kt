package com.example.e_commerceapp.ui.fragments.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.CategoryItemDTO
import com.example.domain.entities.Resource

import com.example.domain.usecases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getCategoriesUseCase: GetCategoriesUseCase

) : ViewModel() {

    val categoryResourceFlow : Flow<Resource<List<CategoryItemDTO>>>
    get() = categoryChannel.consumeAsFlow()
    private val categoryChannel = Channel<Resource<List<CategoryItemDTO>>>()
    val homeIntents = Channel<HomeIntents>()
    var state by mutableStateOf(HomeState())
    private set



    fun state() {
        viewModelScope.launch {
                state = state.copy(
                    isLoading = true,
                    error = null
                )
            getCategoriesUseCase.invoke().collect() {
                when (it){
                    is Resource.Success -> state = state.copy(
                        categoriesInfo = it.data,
                        isLoading = false
                    )

                    is Resource.Error -> state =state.copy(
                        error = state.error,
                        categoriesInfo = null
                    )
                    is Resource.Loading ->  state = state.copy(
                        isLoading = true,
                        error = null
                    )
                }
            }
        }
    }
    fun processNewIntents(){

        viewModelScope.launch {
    homeIntents.consumeAsFlow().collect(){

        when (it){
            is HomeIntents.getCategoriesData -> {
                getCategoriesUseCase.invoke().collect(){
                    categoryChannel.send(it)
                }
        }
    }
}

        }
}
}