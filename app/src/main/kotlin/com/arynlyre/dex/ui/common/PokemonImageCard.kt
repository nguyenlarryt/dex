package com.arynlyre.dex.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.coil.CoilImageState
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun PokemonImageCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    shape: Shape = MaterialTheme.shapes.medium,
    loading: @Composable (BoxScope.(imageState: CoilImageState.Loading) -> Unit)? = null
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Card(modifier, shape) {
        CoilImage(
            modifier = Modifier.fillMaxSize().background(
                color =
                if (palette == null) MaterialTheme.colors.surface
                else Color(palette?.getDominantColor(android.graphics.Color.LTGRAY)!!)
            ).padding(16.dp),
            imageModel = imageUrl,
            bitmapPalette = BitmapPalette { palette = it },
            contentScale = ContentScale.Inside,
            loading = loading
        )
    }
}
