package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetNewsFromFavouriteUseCase @Inject constructor(private val repository: Repository) {

    fun execute(): Flowable<List<MyNews>> {
        return repository.getNewsFromFavourite()
    }
}