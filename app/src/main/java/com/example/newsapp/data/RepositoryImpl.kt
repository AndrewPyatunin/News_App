package com.example.newsapp.data

import com.example.newsapp.domain.NewsFromDb
import com.example.newsapp.domain.NewsFromSources
import com.example.newsapp.domain.NewsFromTopHeadlines
import com.example.newsapp.domain.Repository

object RepositoryImpl : Repository {
    override fun getNewsFromTopHeadlines(): NewsFromTopHeadlines {
        TODO("Not yet implemented")
    }

    override fun getNewsFromFavourite(): NewsFromDb {
        TODO("Not yet implemented")
    }

    override fun getNewsFromSources(): NewsFromSources {
        TODO("Not yet implemented")
    }

    override fun addNewsToFavourite() {
        TODO("Not yet implemented")
    }

    override fun deleteNewsFromFavourite() {
        TODO("Not yet implemented")
    }
}