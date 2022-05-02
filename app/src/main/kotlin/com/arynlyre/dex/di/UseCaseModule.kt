package com.arynlyre.dex.di

import com.arynlyre.dex.domain.repository.PokemonRepository
import com.arynlyre.dex.domain.usecase.GetPokemonDetails
import com.arynlyre.dex.domain.usecase.GetPokemonPage
import com.arynlyre.dex.domain.usecase.getPokemonDetails
import com.arynlyre.dex.domain.usecase.getPokemonPage
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class UseCaseModule {
    @Factory
    fun provideGetPokemonDetails(pokemonRepository: PokemonRepository) = GetPokemonDetails { name ->
        getPokemonDetails(name, pokemonRepository)
    }

    @Factory
    fun provideGetPokemonPage(pokemonRepository: PokemonRepository) = GetPokemonPage { offset ->
        getPokemonPage(offset, pokemonRepository)
    }
}
