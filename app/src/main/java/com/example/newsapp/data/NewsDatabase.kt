package com.example.newsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsFromDb::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {
        private var db: NewsDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): NewsDatabase {
            db?.let {
                return it
            }
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