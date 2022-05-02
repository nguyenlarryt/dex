package com.arynlyre.dex.ui.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.arynlyre.dex.domain.model.PokemonItem
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun PokemonListItem(modifier: Modifier = Modifier, pokemonItem: PokemonItem) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Card(
        modifier = modifier
    ) {
        CoilImage(
            modifier = Modifier.size(100.dp).background(
                color =
                if (palette == null) MaterialTheme.colors.surface
                else Color(palette?.getDominantColor(android.graphics.Color.LTGRAY)!!)
            ).padding(16.dp),
            imageModel = pokemonItem.imageUrl,
            bitmapPalette = BitmapPalette { palette = it },
            contentScale = ContentScale.Inside,
            loading = {
                Box(modifier = Modifier.size(100.dp).background(MaterialTheme.colors.surface)) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        )
    }
}
