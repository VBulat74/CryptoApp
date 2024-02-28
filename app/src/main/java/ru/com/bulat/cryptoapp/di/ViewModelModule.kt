package ru.com.bulat.cryptoapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.com.bulat.cryptoapp.presentation.CoinViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCoinViewModel (viewModel : CoinViewModel) : ViewModel
}