package com.example.domain.usecases

import com.example.domain.entities.CategoryItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {

    suspend operator fun invoke() : Flow<Resource<List<CategoryItemDTO>>> {

        return categoriesRepository.getCategories()

    }
}