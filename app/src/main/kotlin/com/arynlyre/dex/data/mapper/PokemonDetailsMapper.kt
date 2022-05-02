package com.arynlyre.dex.data.mapper

import com.arynlyre.dex.data.dto.BaseStatDto
import com.arynlyre.dex.data.dto.PokemonDetailsDto
import com.arynlyre.dex.data.dto.Stat
import com.arynlyre.dex.data.dto.StatDto
import com.arynlyre.dex.domain.model.PokemonDetails
import com.arynlyre.dex.domain.model.Stats
import org.koin.core.annotation.Factory

@Factory
class PokemonDetailsMapper : DomainMapper<PokemonDetailsDto, PokemonDetails>() {
    override fun mapToDomainModel(dto: PokemonDetailsDto): PokemonDetails {
        var hp: Int = 0
        var atk: Int = 0
        var def: Int = 0
        var spatk: Int = 0
        var spdef: Int = 0
        var spd: Int = 0

        dto.stats.forEach {
            when (it.stat.name) {
                Stat.HP -> hp = it.base_stat
                Stat.ATK -> atk = it.base_stat
                Stat.DEF -> def = it.base_stat
                Stat.SPATK -> spatk = it.base_stat
                Stat.SPDEF -> spdef = it.base_stat
                Stat.SPD -> spd = it.base_stat
            }
        }
        return PokemonDetails(
            dto.id,
            dto.name,
            Stats(hp = hp, attk = atk, def = def, spattk = spatk, spdef = spdef, speed = spd)
        )
    }
    override fun mapToDto(model: PokemonDetails): PokemonDetailsDto {
        val stats = mutableListOf<BaseStatDto>()

        stats.add(BaseStatDto(model.stats.hp, StatDto(Stat.HP)))
        stats.add(BaseStatDto(model.stats.attk, StatDto(Stat.ATK)))
        stats.add(BaseStatDto(model.stats.def, StatDto(Stat.DEF)))
        stats.add(BaseStatDto(model.stats.spattk, StatDto(Stat.SPATK)))
        stats.add(BaseStatDto(model.stats.spdef, StatDto(Stat.SPDEF)))
        stats.add(BaseStatDto(model.stats.speed, StatDto(Stat.SPD)))

        return PokemonDetailsDto(model.id, model.name, stats)
    }
}
