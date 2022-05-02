package com.arynlyre.dex.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import com.arynlyre.dex.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

data class PokemonDetailsScreen(val pokemonName: String) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<PokemonDetailsViewModel> { parametersOf(PokemonDetailsState(pokemonName)) }
        val state: PokemonDetailsState by viewModel.state.observeAsState()

        MaterialTheme {
            Column(Modifier.fillMaxSize()) {
                Text(pokemonName)
                Text(
                    """ HP is ${state.pokemonDetails?.stats?.hp}
                        | ATK is ${state.pokemonDetails?.stats?.attk}
                        | DEF is ${state.pokemonDetails?.stats?.def}
                        | SPATK is ${state.pokemonDetails?.stats?.spattk}
                        | SPDEF is ${state.pokemonDetails?.stats?.spdef}
                        | SPD is ${state.pokemonDetails?.stats?.speed}
                    """.trimMargin()
                )
            }
        }
    }
}
