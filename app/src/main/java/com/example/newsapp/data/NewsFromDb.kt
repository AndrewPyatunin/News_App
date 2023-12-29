package com.example.newsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_news")
data class NewsFromDb(
    @PrimaryKey val id: String,
    val sourceName: String,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
) {
}