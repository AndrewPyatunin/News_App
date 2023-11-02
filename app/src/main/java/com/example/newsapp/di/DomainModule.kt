package com.example.newsapp.di

import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository
}