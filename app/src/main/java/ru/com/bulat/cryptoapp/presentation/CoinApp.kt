package ru.com.bulat.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import ru.com.bulat.cryptoapp.data.database.AppDatabase
import ru.com.bulat.cryptoapp.data.maper.CoinMapper
import ru.com.bulat.cryptoapp.data.network.ApiFactory
import ru.com.bulat.cryptoapp.data.workers.RefreshDataWorkerFactory
import ru.com.bulat.cryptoapp.di.DaggerAppComponent

class CoinApp : Application(), Configuration.Provider {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    AppDatabase.getInstance(this).coinPriceInfoDao(),
                    ApiFactory.apiService,
                    CoinMapper(),
                )
            ).build()
}