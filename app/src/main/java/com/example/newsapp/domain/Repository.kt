package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines>

    fun getNewsFromFavourite(): List<NewsFromDb>

    fun getNewsFromSources(url: String): Single<NewsFromSources>

    fun addNewsToFavourite(newsFromDb: NewsFromDb)

    fun deleteNewsFromFavourite(news: NewsFromDb)
}