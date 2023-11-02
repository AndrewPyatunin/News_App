package com.example.newsapp.domain

import com.example.newsapp.presentation.MyNews
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DeleteNewsFromFavouriteUseCase @Inject constructor(private val repository: Repository) {

    fun execute(myNews: MyNews): Completable {
        return repository.deleteNewsFromFavourite(myNews)
    }
}