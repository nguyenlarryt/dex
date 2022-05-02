package com.arynlyre.dex.domain.usecase

import com.arynlyre.dex.domain.model.PokemonDetails
import com.arynlyre.dex.domain.repository.PokemonRepository

fun interface GetPokemonDetails {
    suspend operator fun invoke(name: String): PokemonDetails
}

suspend fun getPokemonDetails(
    name: String,
    pokemonRepository: PokemonRepository
): PokemonDetails = pokemonRepository.getPokemonDetails(name)
