package com.example.data.repositoriesContracts.categories

import com.example.domain.entities.CategoryItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.CategoriesOnlineDataSource
import com.example.domain.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(private val categoriesOnlineDataSource: CategoriesOnlineDataSource) : CategoriesRepository {
    override suspend fun getCategories(): Flow<Resource<List<CategoryItemDTO>>> {

        return categoriesOnlineDataSource.getCategories()

    }
}