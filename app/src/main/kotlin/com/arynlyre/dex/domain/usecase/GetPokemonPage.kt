package com.arynlyre.dex.domain.usecase

import com.arynlyre.dex.domain.model.PokemonPage
import com.arynlyre.dex.domain.repository.PokemonRepository

fun interface GetPokemonPage {
    suspend operator fun invoke(offset: Int): PokemonPage
}

suspend fun getPokemonPage(
    offset: Int,
    pokemonPokemonRepository: PokemonRepository
): PokemonPage = pokemonPokemonRepository.getPokemonPage(offset)
