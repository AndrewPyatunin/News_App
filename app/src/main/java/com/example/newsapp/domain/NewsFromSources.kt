package com.example.newsapp.domain

data class NewsFromSources(val status: String, val sources: List<SourceDetail>) {
}