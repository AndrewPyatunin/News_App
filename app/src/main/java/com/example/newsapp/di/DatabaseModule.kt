package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.NewsDao
import com.example.newsapp.data.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): NewsDatabase {
        return NewsDatabase.getInstance(context)
    }
    @Provides
    fun provideDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao()
    }
}