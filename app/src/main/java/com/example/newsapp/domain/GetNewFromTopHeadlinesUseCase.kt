package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Single

class GetNewFromTopHeadlinesUseCase(private val repository: Repository) {
    fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines> {
        return repository.getNewsFromTopHeadlines(url)
    }
}