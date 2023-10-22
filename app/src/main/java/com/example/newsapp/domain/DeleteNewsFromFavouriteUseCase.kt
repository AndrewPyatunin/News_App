package com.example.newsapp.domain

class DeleteNewsFromFavouriteUseCase(private val repository: Repository) {
    fun deleteNewsFromFavourite() {
        repository.deleteNewsFromFavourite()
    }
}