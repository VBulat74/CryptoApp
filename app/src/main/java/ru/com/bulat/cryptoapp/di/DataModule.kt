package ru.com.bulat.cryptoapp.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.com.bulat.cryptoapp.data.database.AppDatabase
import ru.com.bulat.cryptoapp.data.database.CoinInfoDao
import ru.com.bulat.cryptoapp.data.network.ApiFactory
import ru.com.bulat.cryptoapp.data.network.ApiService
import ru.com.bulat.cryptoapp.data.repository.CoinRepositoryImpl
import ru.com.bulat.cryptoapp.domain.CoinRepository

@Module
interface DataModule {

    @Binds
    @AppScope
    fun bindCoinRepository(impl: CoinRepositoryImpl) : CoinRepository

    companion object{

        @Provides
        @AppScope
        fun provideCoinInfoDao(
            application : Application
        ) : CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @AppScope
        fun provideApiService() : ApiService {
            return ApiFactory.apiService
        }
    }
}