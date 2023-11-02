package com.example.newsapp.di

import androidx.lifecycle.ViewModel
import com.example.newsapp.presentation.DetailNewsViewModel
import com.example.newsapp.presentation.FavouriteNewsViewModel
import com.example.newsapp.presentation.GlobalNewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(GlobalNewsViewModel::class)
    @Binds
    fun bindGlobalViewModel(impl: GlobalNewsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(DetailNewsViewModel::class)
    @Binds
    fun bindDetailViewModel(impl: DetailNewsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(FavouriteNewsViewModel::class)
    @Binds
    fun bindFavouriteViewModel(impl: FavouriteNewsViewModel): ViewModel
}