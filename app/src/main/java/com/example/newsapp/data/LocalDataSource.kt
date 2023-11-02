package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface LocalDataSource {
    fun getNewsFromDb(): Flowable<List<NewsFromDb>>

    fun addNewsToDb(news: NewsFromDb): Completable

    fun deleteNewsFromDb(news: NewsFromDb): Completable
}