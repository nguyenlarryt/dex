package com.arynlyre.dex.ui.list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arynlyre.dex.ui.list.PokemonListState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonGridList(
    modifier: Modifier = Modifier,
    state: PokemonListState,
    onPokemonClicked: (name: String, imageUrl: String) -> Unit,
    onListEndReached: () -> Unit
) {
    val listState = rememberLazyListState()
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 12.dp,
            end = 12.dp,
            bottom = 12.dp
        ),
        state = listState
    ) {
        itemsIndexed(state.pokemonItems) { index, pokemon ->
            PokemonListItem(
                Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .clickable { onPokemonClicked(pokemon.name, pokemon.imageUrl) },
                pokemonItem = pokemon
            )
            if (index == state.pokemonItems.lastIndex) onListEndReached()
        }
    }
}
