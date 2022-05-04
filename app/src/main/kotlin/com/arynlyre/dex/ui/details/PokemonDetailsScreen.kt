package com.arynlyre.dex.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.androidx.AndroidScreen
import com.arynlyre.dex.ui.details.components.PokemonDetailsContent
import com.arynlyre.dex.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

data class PokemonDetailsScreen(
    val pokemonName: String,
    val imageUrl: String
) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<PokemonDetailsViewModel> { parametersOf(PokemonDetailsState(pokemonName, imageUrl)) }
        val state: PokemonDetailsState by viewModel.state.observeAsState()

        PokemonDetailsContent(state)
    }
}
