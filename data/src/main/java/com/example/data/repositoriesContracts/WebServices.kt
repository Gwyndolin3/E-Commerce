package com.example.data.repositoriesContracts

import com.example.data.model.CategoriesResponse
import retrofit2.http.GET

interface WebServices  {
    @GET("/api/v1/categories")
    suspend fun getCategories() : CategoriesResponse
}