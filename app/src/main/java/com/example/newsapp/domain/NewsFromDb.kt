package com.example.newsapp.domain

import androidx.room.Entity

@Entity(tableName = "favourite_news")
data class NewsFromDb(val id: String, val article: Article) {

}