package ru.com.bulat.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.com.bulat.cryptoapp.data.repository.CoinRepositoryImpl
import ru.com.bulat.cryptoapp.domain.GetCoinInfoListUseCase
import ru.com.bulat.cryptoapp.domain.GetCoinInfoUseCase
import ru.com.bulat.cryptoapp.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDaUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDaUseCase()
    }
}