package com.arynlyre.dex.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetailsDto(val id: Int, val name: String, val stats: List<BaseStatDto>)
