package com.example.newsapp.domain

class DeleteNewsFromFavouriteUseCase(private val repository: Repository) {
    fun deleteNewsFromFavourite(newsFromDb: NewsFromDb) {
        repository.deleteNewsFromFavourite(newsFromDb)
    }
}