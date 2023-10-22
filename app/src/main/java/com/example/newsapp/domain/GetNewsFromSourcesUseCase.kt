package com.example.newsapp.domain

class GetNewsFromSourcesUseCase(private val repository: Repository) {
    fun getNewsFromSources(url: String): NewsFromSources {
        return repository.getNewsFromSources(url)
    }
}