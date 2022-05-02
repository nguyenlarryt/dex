package com.arynlyre.dex.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonItemDto(val name: String, val url: String)

fun PokemonItemDto.imageUrl(): String {
    val index = url.split("/".toRegex()).dropLast(1).last()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}
