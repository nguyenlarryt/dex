package com.arynlyre.dex.data.remote

import com.arynlyre.dex.data.dto.PokemonDetailsDto
import com.arynlyre.dex.data.dto.PokemonResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDetailsDto

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 30,
        @Query("offset") offset: Int = 0
    ): PokemonResponseDto
}
