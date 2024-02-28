package ru.com.bulat.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import ru.com.bulat.cryptoapp.domain.GetCoinInfoListUseCase
import ru.com.bulat.cryptoapp.domain.GetCoinInfoUseCase
import ru.com.bulat.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase : GetCoinInfoListUseCase,
    private val getCoinInfoUseCase : GetCoinInfoUseCase,
    private val loadDaUseCase : LoadDataUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym : String) = getCoinInfoUseCase(fSym)

    init {
        loadDaUseCase()
    }
}