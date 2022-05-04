package com.arynlyre.dex.ui.details

import com.arynlyre.dex.domain.model.PokemonDetails

data class PokemonDetailsState(
    val name: String,
    val imageUrl: String,
    val pokemonDetails: PokemonDetails? = null
)
