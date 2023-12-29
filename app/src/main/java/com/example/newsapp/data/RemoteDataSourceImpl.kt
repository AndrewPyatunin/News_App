package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(): RemoteDataSource {
    override fun getNews(url: String): Single<NewsFromTopHeadlines> {
        return ApiFactory.apiService.getDataFrom(url)
    }
}