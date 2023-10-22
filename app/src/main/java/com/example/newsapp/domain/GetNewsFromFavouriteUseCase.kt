package com.example.newsapp.domain

class GetNewsFromFavouriteUseCase(private val repository: Repository) {
    fun getNewsFromFavourite(): NewsFromDb {
        return repository.getNewsFromFavourite()
    }
}