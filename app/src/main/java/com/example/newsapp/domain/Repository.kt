package com.example.newsapp.domain

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines>

    fun getNewsFromFavourite(): Flowable<List<MyNews>>

    fun getNewsFromSources(url: String): Single<NewsFromSources>

    fun addNewsToFavourite(myNews: MyNews): Completable

    fun deleteNewsFromFavourite(myNews: MyNews): Completable
}