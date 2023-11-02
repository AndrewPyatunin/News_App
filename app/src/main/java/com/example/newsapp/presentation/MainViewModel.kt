package com.example.newsapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(application: Application): AndroidViewModel(application) {
    lateinit var repository: RepositoryImpl
    private val getNewsFromTopHeadlines = GetNewFromTopHeadlinesUseCase(repository)
    private val getNewsFromSources = GetNewsFromSourcesUseCase(repository)
    private val compositeDisposable = CompositeDisposable()

//    fun getNewsFromTopHeadlines(url: String): Single<NewsFromTopHeadlines> {
//        return Single.fromCallable {
//            getNewsFromTopHeadlines.getNewsFromTopHeadlines(url)
//        }
//    }

    fun getNewsFromInternet(path: String) {
        val disposable = getNewsFromTopHeadlines.execute(path)
            .subscribeOn(Schedulers.io())
            .subscribe( object : Consumer<NewsFromTopHeadlines> {
                override fun accept(t: NewsFromTopHeadlines) {
                    Log.d("MAIN_ACTIVITY_TEST", t.articles.first().author.toString())
                }
            }) {
                Log.d("MAIN_ACTIVITY_TEST", it.message.toString())
            }
        compositeDisposable.add(disposable)
    }

    fun getNewsFrom(url: String) {
        val disposable = getNewsFromSources.execute(url)
            .subscribeOn(Schedulers.io())
            .subscribe( {
                Log.d("MAIN_ACTIVITY_TEST1", it.sources.first().url)
            }, {
                Log.d("MAIN_ACTIVITY_TEST1", it.message.toString())
        })
        compositeDisposable.add(disposable)
    }

//    fun getNewsFromSources(url: String): Single<NewsFromSources> {
//        return Single.fromCallable {
//            getNewsFromSources.getNewsFromSources(url)
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}