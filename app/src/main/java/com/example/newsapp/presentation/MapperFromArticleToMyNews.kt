package com.example.newsapp.presentation

import com.example.newsapp.domain.Article

object MapperFromArticleToMyNews {
    fun mapToMyNews(article: Article): MyNews {
        return MyNews(
            article.source.name,
            article.author,
            article.title,
            article.description,
            article.url,
            article.urlToImage,
            article.publishedAt,
            article.content
        )
    }
    fun mapToListMyNews(listArticle: List<Article>): List<MyNews> {
        return listArticle.map { mapToMyNews(it) }
    }
}