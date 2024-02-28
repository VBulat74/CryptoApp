package ru.com.bulat.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import ru.com.bulat.cryptoapp.data.workers.RefreshDataWorkerFactory
import ru.com.bulat.cryptoapp.di.DaggerAppComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: RefreshDataWorkerFactory

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}