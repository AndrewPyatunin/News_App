package com.example.newsapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsFromTopHeadlines(val status: String, val totalResults: Int, val articles: List<Article>) : Parcelable
