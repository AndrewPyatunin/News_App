package com.example.newsapp.data

import android.app.Application
import com.example.newsapp.domain.NewsFromDb
import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import com.example.newsapp.domain.Repository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

object RepositoryImpl : Repository {
    lateinit var application: Application
    private val db by lazy { NewsDatabase.getInstance(application) }
    private val compositeDisposable = CompositeDisposable()

    override fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines> {
        return ApiFactory.apiService.getDataFrom(url)
    }

    override fun getNewsFromFavourite(): List<NewsFromDb> {
        return db.newsDao().getFavouriteNews()
    }

    override fun getNewsFromSources(url: String): Single<NewsFromSources> {
        return ApiFactory.apiService.getDataFromSomeSources(url)
    }

    override fun addNewsToFavourite(newsFromDb: NewsFromDb) {
        db.newsDao().addNewsToFavourite(newsFromDb)
    }

    override fun deleteNewsFromFavourite(news: NewsFromDb) {
        db.newsDao().deleteNewsFromFavourite(news.id)
    }
}