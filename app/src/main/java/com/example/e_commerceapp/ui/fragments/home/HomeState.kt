package com.example.e_commerceapp.ui.fragments.home

import com.example.domain.entities.CategoryItemDTO

data class HomeState(
        val categoriesInfo : List<CategoryItemDTO> ?= null,
        val isLoading : Boolean = false,
        val error: String ?= null
)
