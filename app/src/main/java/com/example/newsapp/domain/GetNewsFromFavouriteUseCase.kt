package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Flowable

class GetNewsFromFavouriteUseCase(private val repository: Repository) {

    fun execute(): Flowable<List<NewsFromDb>> {
        return repository.getNewsFromFavourite()
    }
}