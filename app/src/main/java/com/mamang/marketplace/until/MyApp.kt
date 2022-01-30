package com.mamang.marketplace.until

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.mamang.marketplace.core.di.appModule
import com.mamang.marketplace.core.di.repositoryModule
import com.mamang.marketplace.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}