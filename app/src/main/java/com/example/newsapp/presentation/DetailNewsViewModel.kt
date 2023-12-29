package com.example.newsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.AddNewsToFavouriteUseCase
import com.example.newsapp.domain.DeleteNewsFromFavouriteUseCase
import com.example.newsapp.domain.GetNewsFromFavouriteUseCase
import com.example.newsapp.domain.MyNews
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailNewsViewModel @Inject constructor(
    private val getNewsFromFavouriteUseCase: GetNewsFromFavouriteUseCase,
    private val deleteNewsFromFavouriteUseCase: DeleteNewsFromFavouriteUseCase,
    private val addNewsToFavouriteUseCase: AddNewsToFavouriteUseCase,
    ) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private var _favouritesLiveData = MutableLiveData<List<MyNews>>()
    val favouritesLiveData: LiveData<List<MyNews>> = _favouritesLiveData

    private var _resultLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        getFavouriteNews()
    }

    fun getFavouriteNews() {
        getNewsFromFavouriteUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _favouritesLiveData.postValue(it)
            }, {
                _resultLiveData.postValue(it.message)
            })
    }

    fun deleteNewsFromFavourite(myNews: MyNews) {
        val disposable = deleteNewsFromFavouriteUseCase.execute(myNews)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _resultLiveData.postValue("Удаление прошло успешно!")
            }, {
                _resultLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposable)
    }

    fun addNewsToFavourite(myNews: MyNews) {
        val disposable = addNewsToFavouriteUseCase
            .execute(myNews)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _resultLiveData.postValue("Добавление прошло успешно!")
            }, {
                _resultLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}