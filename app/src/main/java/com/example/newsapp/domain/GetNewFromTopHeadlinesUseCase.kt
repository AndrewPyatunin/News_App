package com.example.newsapp.domain

class GetNewFromTopHeadlinesUseCase(private val repository: Repository) {
    fun getNewsFromTopHeadlines(): NewsFromTopHeadlines {
        return repository.getNewsFromTopHeadlines()
    }
}