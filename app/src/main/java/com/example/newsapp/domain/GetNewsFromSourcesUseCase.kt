package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetNewsFromSourcesUseCase @Inject constructor(private val repository: Repository) {
    fun execute(url: String): Single<NewsFromSources> {
        return repository.getNewsFromSources(url)
    }
}