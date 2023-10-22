package com.example.newsapp.data

import androidx.room.*
import com.example.newsapp.domain.NewsFromDb

@Dao
interface NewsDao {
    @Query("SELECT * FROM favourite_news")
    fun getFavouriteNews(): List<NewsFromDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewsToFavourite(news: NewsFromDb)

    @Delete
    fun deleteNewsFromFavourite(news: NewsFromDb)
}