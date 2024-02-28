package ru.com.bulat.cryptoapp.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.com.bulat.cryptoapp.data.workers.ChildWorkerFactory
import ru.com.bulat.cryptoapp.data.workers.RefreshDataWorker

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory) : ChildWorkerFactory
}