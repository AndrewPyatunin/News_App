package com.example.newsapp.di

import android.content.Context
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