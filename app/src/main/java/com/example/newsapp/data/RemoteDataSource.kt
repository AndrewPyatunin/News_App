package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getNews(url: String): Single<NewsFromTopHeadlines>
}