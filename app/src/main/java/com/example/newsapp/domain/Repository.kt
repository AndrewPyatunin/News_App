package com.example.newsapp.domain

interface Repository {

    fun getNewsFromTopHeadlines(): NewsFromTopHeadlines

    fun getNewsFromFavourite(): NewsFromDb

    fun getNewsFromSources(): NewsFromSources

    fun addNewsToFavourite()

    fun deleteNewsFromFavourite()
}