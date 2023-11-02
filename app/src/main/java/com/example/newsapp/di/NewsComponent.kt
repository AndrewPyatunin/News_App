package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.presentation.DetailNewsFragment
import com.example.newsapp.presentation.FavouriteNewsFragment
import com.example.newsapp.presentation.GlobalNewsFragment
import dagger.BindsInstance
import dagger.Component
@AppScope
@Component(modules = [DatabaseModule::class, DataModule::class, DomainModule::class, ViewModelModule::class])
interface NewsComponent {

    fun fragmentComponent(): FragmentComponent

    @Component.Factory
    interface NewsComponentFactory {
        fun create(
            @BindsInstance context: Context
        ): NewsComponent
    }
}