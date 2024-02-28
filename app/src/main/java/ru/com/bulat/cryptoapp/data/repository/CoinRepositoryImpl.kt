package ru.com.bulat.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import ru.com.bulat.cryptoapp.data.database.CoinInfoDao
import ru.com.bulat.cryptoapp.data.maper.CoinMapper
import ru.com.bulat.cryptoapp.data.workers.RefreshDataWorker
import ru.com.bulat.cryptoapp.domain.CoinInfo
import ru.com.bulat.cryptoapp.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val application: Application,
    private val coinInfoDao : CoinInfoDao,
    private val mapper : CoinMapper,
) : CoinRepository {

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest(),
        )
    }
}