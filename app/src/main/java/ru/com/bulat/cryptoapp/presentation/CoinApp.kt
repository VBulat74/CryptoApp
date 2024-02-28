package ru.com.bulat.cryptoapp.presentation

import android.app.Application
import ru.com.bulat.cryptoapp.di.DaggerAppComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

}