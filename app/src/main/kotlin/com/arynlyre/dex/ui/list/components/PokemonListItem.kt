package com.arynlyre.dex.ui.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arynlyre.dex.domain.model.PokemonItem
import com.arynlyre.dex.ui.common.PokemonImageCard

@Composable
fun PokemonListItem(modifier: Modifier = Modifier, pokemonItem: PokemonItem) {
    PokemonImageCard(
        modifier,
        pokemonItem.imageUrl,
        loading = {
            Box(modifier = Modifier.size(100.dp).background(MaterialTheme.colors.surface)) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}
