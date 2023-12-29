package com.example.newsapp.di

import com.example.newsapp.presentation.DetailNewsFragment
import com.example.newsapp.presentation.FavouriteNewsFragment
import com.example.newsapp.presentation.GlobalNewsFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentComponent {
    fun inject(fragment: GlobalNewsFragment)

    fun inject(fragment: DetailNewsFragment)

    fun inject(fragment: FavouriteNewsFragment)
}