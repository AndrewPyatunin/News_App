package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromDb
import com.example.newsapp.presentation.MyNews
import javax.inject.Inject

class MapperToDb @Inject constructor() {
    fun mapToDb(article: MyNews): NewsFromDb {
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