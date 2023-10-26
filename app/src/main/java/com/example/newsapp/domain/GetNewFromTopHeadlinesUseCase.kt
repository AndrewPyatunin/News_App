package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Single

class GetNewFromTopHeadlinesUseCase(private val repository: Repository) {
    fun execute(url: String): Single<NewsFromTopHeadlines> {
        return repository.getNewsFromTopHeadlines(url)
    }
}