package com.arynlyre.dex.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseStatDto(val base_stat: Int, val stat: StatDto)

@JsonClass(generateAdapter = true)
data class StatDto(val name: Stat)

enum class Stat {
    @Json(name = "hp") HP,
    @Json(name = "attack") ATK,
    @Json(name = "defense") DEF,
    @Json(name = "special-attack") SPATK,
    @Json(name = "special-defense") SPDEF,
    @Json(name = "speed") SPD
}
