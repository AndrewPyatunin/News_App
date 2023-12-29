package com.example.newsapp.domain

data class NewsFromTopHeadlines(val status: String, val totalResults: Int, val articles: List<Article>)
