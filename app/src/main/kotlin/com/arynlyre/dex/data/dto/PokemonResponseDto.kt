package com.arynlyre.dex.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonResponseDto(val count: Int, val results: List<PokemonItemDto>)
