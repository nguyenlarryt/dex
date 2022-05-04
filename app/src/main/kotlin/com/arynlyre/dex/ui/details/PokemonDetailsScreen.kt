package com.arynlyre.dex.ui.details

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.dex.R
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

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.details_title), fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            PokemonDetailsContent(state)
        }
    }
}
