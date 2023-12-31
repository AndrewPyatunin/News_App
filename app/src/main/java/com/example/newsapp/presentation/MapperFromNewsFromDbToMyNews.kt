package com.example.newsapp.presentation

import com.example.newsapp.data.NewsFromDb
import com.example.newsapp.domain.MyNews

class MapperFromNewsFromDbToMyNews {
    fun mapToMyNews(newsFromDb: NewsFromDb): MyNews {
        return MyNews(
            newsFromDb.sourceName,
            newsFromDb.author,
            newsFromDb.title,
            newsFromDb.description,
            newsFromDb.url,
            newsFromDb.urlToImage,
            newsFromDb.publishedAt,
            newsFromDb.content
        )
    }

    fun mapToListMyNews(listNewsFromDb: List<NewsFromDb>): List<MyNews> {
        return listNewsFromDb.map { mapToMyNews(it) }
    }
}