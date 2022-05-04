package com.arynlyre.dex.ui.list

import com.arynlyre.dex.domain.model.PokemonItem

data class PokemonListState(
    val pokemonItems: List<PokemonItem> = emptyList(),
    val offset: Int = 0,
    val count: Int = 0,
    val showLoading: Boolean = false
) {
    val hasMore: Boolean = offset <= count
}
