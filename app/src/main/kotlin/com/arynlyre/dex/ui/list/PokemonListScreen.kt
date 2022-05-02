package com.arynlyre.dex.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.dex.ui.details.PokemonDetailsScreen
import com.arynlyre.dex.ui.list.components.PokemonGridList
import com.arynlyre.dex.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

class PokemonListScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<PokemonViewModel> { parametersOf(PokemonListState()) }
        val state: PokemonListState by viewModel.state.observeAsState()

        val navigator = LocalNavigator.currentOrThrow

        MaterialTheme {
            Box(modifier = Modifier.fillMaxSize()) {
                PokemonGridList(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onPokemonClicked = { name -> navigator.push(PokemonDetailsScreen(name)) },
                    bottomReached = { viewModel.process(ListEndReached) }
                )

                if (state.showLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.background(Color.Transparent)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
