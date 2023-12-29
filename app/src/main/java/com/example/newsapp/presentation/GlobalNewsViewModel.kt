package com.example.newsapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.GetNewFromTopHeadlinesUseCase
import com.example.newsapp.domain.NewsFromTopHeadlines
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GlobalNewsViewModel @Inject constructor(
    private val getNewsFromTopHeadlinesUseCase: GetNewFromTopHeadlinesUseCase
) : ViewModel() {

    private var _topNewsLiveData = MutableLiveData<NewsFromTopHeadlines>()
    val topNewsLiveData: LiveData<NewsFromTopHeadlines>
        get() = _topNewsLiveData

    private var _errorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = _errorLiveData

    fun getNews(path: String) {
        getNewsFromTopHeadlinesUseCase.execute(path)
            .subscribeOn(Schedulers.io())
            .subscribe({
                _topNewsLiveData.postValue(it)
            }, {
                _errorLiveData.postValue(it)
            })
    }
}