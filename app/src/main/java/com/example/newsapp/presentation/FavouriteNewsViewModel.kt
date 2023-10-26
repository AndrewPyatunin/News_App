package com.example.newsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.RepositoryImpl
import com.example.newsapp.domain.GetNewsFromFavouriteUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class FavouriteNewsViewModel: ViewModel() {
    private val repository = RepositoryImpl
    private val getNewsFromFavouriteUseCase = GetNewsFromFavouriteUseCase(repository)

    private var _listFavouriteLiveData = MutableLiveData<List<MyNews>>()
    val listFavouriteLiveData: LiveData<List<MyNews>> = _listFavouriteLiveData
    init {
        getListNews()
    }

    private fun getListNews() {
        getNewsFromFavouriteUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                _listFavouriteLiveData.value = MapperFromNewsFromDbToMyNews.mapToListMyNews(it)
            }, {

            })
//        _listFavouriteLiveData.value = MapperFromNewsFromDbToMyNews.mapToListMyNews(listNews)
    }
}