package com.mamang.marketplace.core.di

import com.mamang.marketplace.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}