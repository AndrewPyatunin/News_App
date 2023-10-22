package com.example.newsapp.domain

class GetNewsFromSourcesUseCase(private val repository: Repository) {
    fun getNewsFromSources(): NewsFromSources {
        return repository.getNewsFromSources()
    }
}