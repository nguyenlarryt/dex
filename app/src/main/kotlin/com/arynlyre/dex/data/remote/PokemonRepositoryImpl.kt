package com.arynlyre.dex.data.remote

import com.arynlyre.dex.data.dto.PokemonResponseDto
import com.arynlyre.dex.data.mapper.PokemonDetailsMapper
import com.arynlyre.dex.data.mapper.PokemonItemMapper
import com.arynlyre.dex.domain.model.PokemonDetails
import com.arynlyre.dex.domain.model.PokemonItem
import com.arynlyre.dex.domain.model.PokemonPage
import com.arynlyre.dex.domain.repository.PokemonRepository
import org.koin.core.annotation.Single

@Single
class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi,
    private val mapper: PokemonItemMapper,
    private val detailsMapper: PokemonDetailsMapper
) : PokemonRepository {

    override suspend fun getPokemonPage(offset: Int): PokemonPage {
        val response: PokemonResponseDto = pokemonApi.getPokemonList(offset = offset)

        val pokemons: List<PokemonItem> = mapper.mapToDomainList(response.results)

        return PokemonPage(response.count, pokemons)
    }

    override suspend fun getPokemonDetails(name: String): PokemonDetails {
        return detailsMapper.mapToDomainModel(pokemonApi.getPokemon(name))
    }
}
