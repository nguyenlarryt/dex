package com.arynlyre.dex.di

import com.arynlyre.dex.BuildConfig
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val MAX_CACHE_SIZE: Long = 10 * 1024 * 1024

val netModule = module {
    factory { Cache(androidContext().cacheDir, MAX_CACHE_SIZE) }

    factory { MoshiConverterFactory.create() }

    single {
        OkHttpClient.Builder()
            .cache(get())
            .apply { if (BuildConfig.DEBUG) addInterceptor(ChuckerInterceptor.Builder(androidContext()).build()) }
            .build()
    }
}

fun getRetrofit(
    baseUrl: String,
    client: OkHttpClient,
    converterFactory: MoshiConverterFactory
): Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(client)
    .addConverterFactory(converterFactory)
    .build()
