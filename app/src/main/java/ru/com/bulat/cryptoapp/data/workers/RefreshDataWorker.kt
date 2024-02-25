package ru.com.bulat.cryptoapp.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import ru.com.bulat.cryptoapp.data.database.AppDatabase
import ru.com.bulat.cryptoapp.data.maper.CoinMapper
import ru.com.bulat.cryptoapp.data.network.ApiFactory

class RefreshDataWorker (
    context: Context,
    workerParameters: WorkerParameters,
) : CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinMapper()

    override suspend fun doWork(): Result {
        while (true){
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {

            }
            delay(10_000)
        }
    }

    companion object{

        const val NAME = "RefreshDataWorker"

        fun makeRequest() : OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}