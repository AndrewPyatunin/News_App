package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class AddNewsToFavouriteUseCase @Inject constructor(private val repository: Repository) {

    fun execute(news: MyNews): Completable {
        return repository.addNewsToFavourite(news)
    }

}