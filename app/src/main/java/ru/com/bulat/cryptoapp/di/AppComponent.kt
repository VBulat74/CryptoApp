package ru.com.bulat.cryptoapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.com.bulat.cryptoapp.presentation.CoinDetailFragment
import ru.com.bulat.cryptoapp.presentation.CoinPriceListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    ViewModelModule::class,
])
interface AppComponent {

    fun inject (activity : CoinPriceListActivity)

    fun inject (fragment : CoinDetailFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application : Application,
        ) : AppComponent
    }
}