package com.example.newsapp.domain

import com.example.newsapp.presentation.MyNews
import io.reactivex.rxjava3.core.Completable

class DeleteNewsFromFavouriteUseCase(private val repository: Repository) {

    fun execute(myNews: MyNews): Completable {
        return repository.deleteNewsFromFavourite(myNews)
    }
}