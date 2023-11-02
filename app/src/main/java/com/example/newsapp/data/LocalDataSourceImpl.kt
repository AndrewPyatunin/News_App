package com.example.newsapp.data

import android.app.Application
import com.example.newsapp.domain.NewsFromDb
import com.example.newsapp.presentation.MyNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao

) : LocalDataSource {
//    private val db by lazy { NewsDatabase.getInstance(application) }
    override fun getNewsFromDb(): Flowable<List<NewsFromDb>> {
        return newsDao.getFavouriteNews()
    }

    override fun addNewsToDb(news: NewsFromDb): Completable {
        return newsDao.addNewsToFavourite(news)
    }

    override fun deleteNewsFromDb(news: NewsFromDb): Completable {
        return newsDao.deleteNewsFromFavourite(news.id)
    }
}