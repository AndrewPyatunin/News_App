package com.example.newsapp.data

import com.example.newsapp.domain.MyNews
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
    fun mapToMyNews(newsFromDb: NewsFromDb): MyNews {
        return MyNews(
            sourceName = newsFromDb.sourceName,
            author = newsFromDb.author,
            title = newsFromDb.title,
            description = newsFromDb.description,
            url = newsFromDb.url,
            urlToImage = newsFromDb.urlToImage,
            publishedAt = newsFromDb.publishedAt,
            content = newsFromDb.content
        )
    }
    fun mapListToMyNews(listDb: List<NewsFromDb>): List<MyNews> {
        return listDb.map { mapToMyNews(it) }
    }
}