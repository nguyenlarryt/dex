package com.arynlyre.dex.ui.list

sealed interface PokemonListEvent

object ListEndReached : PokemonListEvent
