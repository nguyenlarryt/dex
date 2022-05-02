package com.arynlyre.dex.domain.model

data class PokemonPage(
    val count: Int = 0,
    val pokemons: List<PokemonItem> = emptyList()
)
