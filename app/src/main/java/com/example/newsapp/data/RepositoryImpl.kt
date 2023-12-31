package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import com.example.newsapp.domain.Repository
import com.example.newsapp.domain.MyNews
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mapper: MapperToDb
) : Repository {

    override fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines> {
        return remoteDataSource.getNews(url)
    }

    override fun getNewsFromFavourite(): Flowable<List<MyNews>> {
        return localDataSource.getNewsFromDb().map {
            mapper.mapListToMyNews(it)
        }
    }

    override fun getNewsFromSources(url: String): Single<NewsFromSources> {
        return ApiFactory.apiService.getDataFromSomeSources(url)
    }

    override fun addNewsToFavourite(myNews: MyNews): Completable {
        return localDataSource.addNewsToDb(map(myNews))
    }

    override fun deleteNewsFromFavourite(myNews: MyNews): Completable {
        return localDataSource.deleteNewsFromDb(map(myNews))
    }

    private fun map(myNews: MyNews): NewsFromDb {
        return mapper.mapToDb(myNews)
    }

}