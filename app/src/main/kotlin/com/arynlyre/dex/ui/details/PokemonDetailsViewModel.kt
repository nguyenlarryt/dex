package com.arynlyre.dex.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arynlyre.dex.domain.usecase.GetPokemonDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam

@KoinViewModel
class PokemonDetailsViewModel(
    @InjectedParam initialState: PokemonDetailsState,
    getPokemonDetails: GetPokemonDetails
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<PokemonDetailsState>
        get() = _state

    init {
        viewModelScope.launch {
            val pokemonDetails = getPokemonDetails(_state.value.name)
            _state.update { it.copy(pokemonDetails = pokemonDetails) }
        }
    }
}
