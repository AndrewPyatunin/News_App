package com.example.newsapp.domain

interface Repository {

    fun getNewsFromTopHeadlines(url: String): NewsFromTopHeadlines

    fun getNewsFromFavourite(): List<NewsFromDb>

    fun getNewsFromSources(url: String): NewsFromSources

    fun addNewsToFavourite(newsFromDb: NewsFromDb)

    fun deleteNewsFromFavourite(news: NewsFromDb)
}