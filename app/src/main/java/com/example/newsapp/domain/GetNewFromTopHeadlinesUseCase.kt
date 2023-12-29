package com.example.newsapp.domain

class GetNewFromTopHeadlinesUseCase(private val repository: Repository) {
    fun getNewsFromTopHeadlines(url: String): NewsFromTopHeadlines {
        return repository.getNewsFromTopHeadlines(url)
    }
}