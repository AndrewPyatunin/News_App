package com.example.newsapp.data

import android.app.Application
import com.example.newsapp.domain.*
import com.example.newsapp.presentation.MyNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

object RepositoryImpl : Repository {
    lateinit var application: Application
    private val db by lazy { NewsDatabase.getInstance(application) }
    private val compositeDisposable = CompositeDisposable()

    override fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines> {
        return ApiFactory.apiService.getDataFrom(url)
    }

    override fun getNewsFromFavourite(): Flowable<List<NewsFromDb>> {
        return db.newsDao().getFavouriteNews()
    }

    override fun getNewsFromSources(url: String): Single<NewsFromSources> {
        return ApiFactory.apiService.getDataFromSomeSources(url)
    }

    override fun addNewsToFavourite(myNews: MyNews): Completable {
        return db.newsDao().addNewsToFavourite(mapToDb(myNews))
    }

    override fun deleteNewsFromFavourite(myNews: MyNews): Completable {
        return db.newsDao().deleteNewsFromFavourite(mapToDb(myNews).id)
    }

    private fun mapToDb(article: MyNews): NewsFromDb {
        return NewsFromDb(
            article.publishedAt + article.url,
            article.sourceName,
            article.author,
            article.title,
            article.description,
            article.url,
            article.urlToImage,
            article.publishedAt,
            article.content
        )
    }
}