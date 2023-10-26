package com.example.newsapp.domain

import com.example.newsapp.presentation.MyNews
import io.reactivex.rxjava3.core.Completable

class AddNewsToFavouriteUseCase(private val repository: Repository) {

    fun execute(news: MyNews): Completable {
        return repository.addNewsToFavourite(news)
    }

}