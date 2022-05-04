package com.arynlyre.dex.domain.model

data class Stats(
    val hp: Int,
    val attk: Int,
    val def: Int,
    val spattk: Int,
    val spdef: Int,
    val speed: Int
)

fun Int.toStatPercentage(): Float = (this.toFloat()) / 150
