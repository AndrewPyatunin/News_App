package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET//("top-headlines?country=us&apiKey=2cd2edc1d12c44978faf4d22ff89b796")
    fun getDataFrom(@Url url: String): Single<NewsFromTopHeadlines>

    @GET//("top-headlines/sources")
    fun getDataFromSomeSources(@Url url: String): Single<NewsFromSources>
}