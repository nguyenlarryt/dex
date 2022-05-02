package com.arynlyre.dex.data.remote

import com.arynlyre.dex.di.getRetrofit
import okhttp3.OkHttpClient
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class DataModule {
    companion object {
        const val POKEMON_API_URL = "https://pokeapi.co/api/v2/"
    }

    @Single
    fun providePokemonApi(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): PokemonApi =
        getRetrofit(POKEMON_API_URL, okHttpClient, moshiConverterFactory)
            .create(PokemonApi::class.java)
}
