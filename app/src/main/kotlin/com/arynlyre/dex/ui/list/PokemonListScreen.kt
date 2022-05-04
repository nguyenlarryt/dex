package com.arynlyre.dex.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.dex.R
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

        Scaffold(
            topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name), fontWeight = FontWeight.Bold) }) }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                PokemonGridList(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onPokemonClicked = { name, imageUrl -> if (navigator.size < 2) navigator.push(PokemonDetailsScreen(name, imageUrl)) },
                    onListEndReached = { viewModel.process(ListEndReached) }
                )

                if (state.showLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
