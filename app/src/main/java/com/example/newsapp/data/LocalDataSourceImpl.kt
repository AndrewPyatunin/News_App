package com.example.newsapp.data

import com.example.newsapp.domain.MyNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.FlowableTransformer
import org.reactivestreams.Publisher
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