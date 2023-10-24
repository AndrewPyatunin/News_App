package com.example.newsapp.data

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.domain.NewsFromDb

@Database(entities = [NewsFromDb::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {
        private var db: NewsDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): NewsDatabase {
            synchronized(lock) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, NewsDatabase::class.java, "MAIN_DB").build()
                db = instance
                return instance
            }
        }
    }
    abstract fun newsDao(): NewsDao
}