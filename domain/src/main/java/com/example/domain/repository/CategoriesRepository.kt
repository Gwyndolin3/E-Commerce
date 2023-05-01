package com.example.domain.repository

import com.example.domain.entities.CategoryItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    suspend fun getCategories() : Flow<Resource<List<CategoryItemDTO>>>

}
interface CategoriesOnlineDataSource {

    suspend fun getCategories() : Flow<Resource<List<CategoryItemDTO>>>

}