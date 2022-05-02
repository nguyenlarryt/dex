package com.arynlyre.dex

import android.app.Application
import com.arynlyre.dex.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule

class DexApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@DexApp)
            modules(defaultModule, appModule)
        }
    }
}
