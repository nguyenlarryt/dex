package com.arynlyre.dex.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arynlyre.dex.domain.usecase.GetPokemonPage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam

@KoinViewModel
class PokemonViewModel(
    @InjectedParam initialState: PokemonListState,
    private val getPokemonPage: GetPokemonPage
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<PokemonListState>
        get() = _state

    companion object {
        const val PAGE_SIZE = 30
    }

    init {
        getNextPokemonPage(0)
    }

    fun getNextPokemonPage(offset: Int) {
        viewModelScope.launch {
            _state.update { it.copy(showLoading = true) }
            val pokemonPage = getPokemonPage(offset)
            _state.update {
                it.copy(
                    count = pokemonPage.count,
                    pokemonItems = it.pokemonItems + pokemonPage.pokemons,
                    showLoading = false
                )
            }
        }
    }

    fun process(event: PokemonListEvent) {
        when (event) {
            ListEndReached -> handleBottomReached()
        }
    }

    private fun handleBottomReached() {
        if (state.value.hasMore) {
            _state.update { it.copy(offset = it.offset + PAGE_SIZE) }
            getNextPokemonPage(state.value.offset)
        }
    }
}
