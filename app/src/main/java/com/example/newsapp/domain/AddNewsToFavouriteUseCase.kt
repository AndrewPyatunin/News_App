package com.example.newsapp.domain

class AddNewsToFavouriteUseCase(private val repository: Repository) {
    fun addNewsToFavourite() {
        repository.addNewsToFavourite()
    }

}