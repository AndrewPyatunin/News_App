package com.example.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private var binding: ActivityMainBinding? = null
    companion object {
        private const val API_KEY = "2cd2edc1d12c44978faf4d22ff89b796"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        GlobalNewsFragment.newInstance()
//        viewModel.getNewsFromInternet("https://newsapi.org/v2/top-headlines?country=us&apiKey=$API_KEY")
//        viewModel.getNewsFrom("https://newsapi.org/v2/top-headlines/sources?apiKey=$API_KEY")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}