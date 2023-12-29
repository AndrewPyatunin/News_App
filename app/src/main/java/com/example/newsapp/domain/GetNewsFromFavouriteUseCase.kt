package com.example.newsapp.domain

class GetNewsFromFavouriteUseCase(private val repository: Repository) {
    fun getNewsFromFavourite(): List<NewsFromDb> {
        return repository.getNewsFromFavourite()
    }
}