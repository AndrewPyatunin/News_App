package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.DaggerNewsComponent
import com.example.newsapp.di.NewsComponent

class NewsApp: Application() {
    val component by lazy { DaggerNewsComponent.factory().create(this) }
}