package com.arynlyre.dex.di

import com.arynlyre.dex.data.remote.DataModule
import org.koin.dsl.module
import org.koin.ksp.generated.module

val appModule = module {
    includes(DataModule().module, netModule, UseCaseModule().module)
}
