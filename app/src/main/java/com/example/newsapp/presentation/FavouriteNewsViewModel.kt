package com.example.newsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.GetNewsFromFavouriteUseCase
import com.example.newsapp.domain.MyNews
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavouriteNewsViewModel @Inject constructor(
    private val getNewsFromFavouriteUseCase: GetNewsFromFavouriteUseCase
    ) : ViewModel() {

    private var _listFavouriteLiveData = MutableLiveData<List<MyNews>>()
    val listFavouriteLiveData: LiveData<List<MyNews>> = _listFavouriteLiveData

    init {
        getListNews()
    }

    private fun getListNews() {
        getNewsFromFavouriteUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _listFavouriteLiveData.value = it
            }, {

            })
//        _listFavouriteLiveData.value = MapperFromNewsFromDbToMyNews.mapToListMyNews(listNews)
    }
}