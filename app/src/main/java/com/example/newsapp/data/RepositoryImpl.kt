package com.example.newsapp.data

import android.app.Application
import com.example.newsapp.domain.NewsFromDb
import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import com.example.newsapp.domain.Repository

object RepositoryImpl : Repository {
    private val context = Application()
    private val db = NewsDatabase.getInstance(context)
    private val PATH = "https://newsapi.org/v2/top-headlines"

    override fun getNewsFromTopHeadlines(url: String): NewsFromTopHeadlines {
        return ApiFactory.apiService.getDataFrom(url)
    }

    override fun getNewsFromFavourite(): List<NewsFromDb> {
        return db.newsDao().getFavouriteNews()
    }

    override fun getNewsFromSources(url: String): NewsFromSources {
        return ApiFactory.apiService.getDataFromSomeSources(url)
    }

    override fun addNewsToFavourite(newsFromDb: NewsFromDb) {
        db.newsDao().addNewsToFavourite(newsFromDb)
    }

    override fun deleteNewsFromFavourite(news: NewsFromDb) {
        db.newsDao().deleteNewsFromFavourite(news)
    }
}