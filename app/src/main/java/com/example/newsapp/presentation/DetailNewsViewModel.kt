package com.example.newsapp.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailNewsViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RepositoryImpl
    private val getNewsFromFavouriteUseCase = GetNewsFromFavouriteUseCase(repository)
    private val deleteNewsFromFavouriteUseCase = DeleteNewsFromFavouriteUseCase(repository)
    private val addNewsToFavouriteUseCase = AddNewsToFavouriteUseCase(repository)
    private val compositeDisposable = CompositeDisposable()

    private var _favouritesLiveData = MutableLiveData<List<MyNews>>()
    val favouritesLiveData: LiveData<List<MyNews>> = _favouritesLiveData

    init {
        getFavouriteNews()
    }
    fun getFavouriteNews() {
        getNewsFromFavouriteUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _favouritesLiveData.postValue(MapperFromNewsFromDbToMyNews.mapToListMyNews(it))
            },{
                Toast.makeText(getApplication(), it.message, Toast.LENGTH_SHORT).show()
            })
    }

    fun deleteNewsFromFavourite(myNews: MyNews) {
        val disposable = deleteNewsFromFavouriteUseCase.execute(myNews)
        .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Toast.makeText(getApplication(), "Удаление прошло успешно!", Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(getApplication(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            })
        compositeDisposable.add(disposable)
    }

    fun addNewsToFavourite(myNews: MyNews) {
        val disposable = addNewsToFavouriteUseCase
            .execute(myNews)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Toast.makeText(getApplication(), "Добавление прошло успешно!", Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(getApplication(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}