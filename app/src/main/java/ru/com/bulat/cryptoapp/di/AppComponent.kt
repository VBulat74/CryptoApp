package ru.com.bulat.cryptoapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.com.bulat.cryptoapp.presentation.CoinApp
import ru.com.bulat.cryptoapp.presentation.CoinDetailFragment
import ru.com.bulat.cryptoapp.presentation.CoinPriceListActivity

@AppScope
@Component(modules = [
    DataModule::class,
    ViewModelModule::class,
    WorkerModule::class,
])
interface AppComponent {

    fun inject (activity : CoinPriceListActivity)

    fun inject (fragment : CoinDetailFragment)

    fun inject (application: CoinApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application : Application,
        ) : AppComponent
    }
}