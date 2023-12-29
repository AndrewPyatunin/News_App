package com.example.newsapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyNews(
    val sourceName: String,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
): Parcelable {
}