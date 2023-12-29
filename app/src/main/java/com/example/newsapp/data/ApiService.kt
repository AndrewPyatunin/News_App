package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getDataFrom(@Url url: String): NewsFromTopHeadlines

    @GET("top-headlines/sources")
    fun getDataFromSomeSources(@Url url: String): NewsFromSources
}