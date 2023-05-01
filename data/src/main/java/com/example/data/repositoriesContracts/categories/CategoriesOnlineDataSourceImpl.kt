package com.example.data.repositoriesContracts.categories

import com.example.data.model.toCategoryItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.CategoryItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.CategoriesOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class CategoriesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices) : CategoriesOnlineDataSource{
    override suspend fun getCategories(): Flow<Resource<List<CategoryItemDTO>>> {

       val response = webServices.getCategories()

        return flow<Resource<List<CategoryItemDTO>>>{

            val successfulResponse = Resource.Success(response.data?.map {
                                        it.toCategoryItemDTO()
            }!!)
            emit(successfulResponse)


        }.onStart {
            emit(Resource.Loading())

        }.catch {
        emit(Resource.Error(it.message ?: "Something is wrong, i can feel it"))



        }
    }


}