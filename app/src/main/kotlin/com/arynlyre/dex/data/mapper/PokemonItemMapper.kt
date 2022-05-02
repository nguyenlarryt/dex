package com.arynlyre.dex.data.mapper

import com.arynlyre.dex.data.dto.PokemonItemDto
import com.arynlyre.dex.data.dto.imageUrl
import com.arynlyre.dex.domain.model.PokemonItem
import org.koin.core.annotation.Factory

@Factory
class PokemonItemMapper : DomainMapper<PokemonItemDto, PokemonItem>() {
    override fun mapToDomainModel(dto: PokemonItemDto): PokemonItem =
        PokemonItem(name = dto.name, imageUrl = dto.imageUrl())

    override fun mapToDto(model: PokemonItem): PokemonItemDto =
        PokemonItemDto(name = model.name, url = model.imageUrl)
}
