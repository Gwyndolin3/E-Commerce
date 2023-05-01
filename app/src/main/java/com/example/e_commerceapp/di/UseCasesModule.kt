package com.example.e_commerceapp.di

import com.example.domain.repository.CategoriesRepository
import com.example.domain.usecases.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideCategoriesUseCases(categoriesRepository: CategoriesRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(categoriesRepository)

    }

}