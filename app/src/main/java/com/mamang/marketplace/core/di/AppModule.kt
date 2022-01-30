package com.mamang.marketplace.core.di

import com.mamang.marketplace.core.data.source.local.LocalDataSource
import com.mamang.marketplace.core.data.source.remote.RemoteDataSource
import com.mamang.marketplace.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }
}