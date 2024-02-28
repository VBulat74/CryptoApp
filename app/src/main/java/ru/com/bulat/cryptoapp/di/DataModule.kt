package ru.com.bulat.cryptoapp.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.com.bulat.cryptoapp.data.database.AppDatabase
import ru.com.bulat.cryptoapp.data.database.CoinInfoDao
import ru.com.bulat.cryptoapp.data.repository.CoinRepositoryImpl
import ru.com.bulat.cryptoapp.domain.CoinRepository

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl) : CoinRepository

    companion object{

        @Provides
        fun provideCoinInfoDao(
            application : Application
        ) : CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}