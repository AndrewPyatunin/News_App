package com.example.newsapp.domain

class AddNewsToFavouriteUseCase(private val repository: Repository) {
    fun addNewsToFavourite(news: NewsFromDb) {
        repository.addNewsToFavourite(news)
    }

}