package com.arynlyre.dex.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arynlyre.dex.domain.model.PokemonDetails
import com.arynlyre.dex.domain.model.Stats
import com.arynlyre.dex.ui.common.PokemonBaseStats
import com.arynlyre.dex.ui.common.PokemonImageCard
import com.arynlyre.dex.ui.details.PokemonDetailsState

@Composable
fun PokemonDetailsContent(state: PokemonDetailsState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PokemonImageCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            imageUrl = state.imageUrl,
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
        )

        Text(text = state.name, style = MaterialTheme.typography.h3)
        if (state.pokemonDetails != null) PokemonBaseStats(modifier = Modifier.fillMaxWidth(), state.pokemonDetails.stats)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsContentPreview() {
    val state = PokemonDetailsState(
        name = "bulbasaur",
        imageUrl = "",
        pokemonDetails = PokemonDetails(
            id = 1,
            name = "bulbasaur",
            stats = Stats(10, 10, 10, 10, 10, 10)
        )
    )

    PokemonDetailsContent(state)
}
