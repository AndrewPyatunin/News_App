package com.example.newsapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.GetNewFromTopHeadlinesUseCase
import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.schedulers.Schedulers

class GlobalNewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RepositoryImpl
    private val getNewsFromTopHeadlines = GetNewFromTopHeadlinesUseCase(repository)

    private var _topNewsLiveData = MutableLiveData<NewsFromTopHeadlines>()
    val topNewsLiveData: LiveData<NewsFromTopHeadlines>
        get() = _topNewsLiveData

    private var _errorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = _errorLiveData

    init {
        repository.application = application
    }
    fun getNews(path: String) {
        getNewsFromTopHeadlines.getNewsFromTopHeadlines(path)
            .subscribeOn(Schedulers.io())
            .subscribe({
                _topNewsLiveData.postValue(it)
            }, {
                _errorLiveData.postValue(it)
            })
    }
}