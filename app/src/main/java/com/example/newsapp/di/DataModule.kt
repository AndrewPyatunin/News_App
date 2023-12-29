package com.example.newsapp.di

import com.example.newsapp.data.LocalDataSource
import com.example.newsapp.data.LocalDataSourceImpl
import com.example.newsapp.data.RemoteDataSource
import com.example.newsapp.data.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @AppScope
    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @AppScope
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}