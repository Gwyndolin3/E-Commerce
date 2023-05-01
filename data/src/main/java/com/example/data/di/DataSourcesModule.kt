package com.example.data.di

import com.example.data.repositoriesContracts.categories.CategoriesOnlineDataSourceImpl
import com.example.domain.repository.CategoriesOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Binds
    @Singleton
    abstract fun bindsCategoryOnlineDataSource(categoriesOnlineDataSourceImpl: CategoriesOnlineDataSourceImpl): CategoriesOnlineDataSource

   
}