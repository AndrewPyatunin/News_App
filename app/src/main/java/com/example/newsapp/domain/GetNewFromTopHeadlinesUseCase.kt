package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetNewFromTopHeadlinesUseCase @Inject constructor(private val repository: Repository) {
    fun execute(url: String): Single<NewsFromTopHeadlines> {
        return repository.getNewsFromTopHeadlines(url)
    }
}