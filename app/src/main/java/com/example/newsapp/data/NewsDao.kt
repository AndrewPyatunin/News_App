package com.example.newsapp.data

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface NewsDao {
    @Query("SELECT * FROM favourite_news")
    fun getFavouriteNews(): Flowable<List<NewsFromDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewsToFavourite(news: NewsFromDb): Completable

    @Query("DELETE FROM favourite_news WHERE id = :id")
    fun deleteNewsFromFavourite(id: String): Completable
}