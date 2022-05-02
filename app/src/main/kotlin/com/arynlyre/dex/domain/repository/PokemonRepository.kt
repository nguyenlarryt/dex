package com.arynlyre.dex.domain.repository

import com.arynlyre.dex.domain.model.PokemonDetails
import com.arynlyre.dex.domain.model.PokemonPage

interface PokemonRepository {
    suspend fun getPokemonPage(offset: Int): PokemonPage
    suspend fun getPokemonDetails(name: String): PokemonDetails
}
