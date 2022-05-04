package com.arynlyre.dex.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arynlyre.dex.domain.model.Stats
import com.arynlyre.dex.domain.model.toStatPercentage
import com.arynlyre.dex.ui.theme.Blue400
import com.arynlyre.dex.ui.theme.Green400
import com.arynlyre.dex.ui.theme.Pink400
import com.arynlyre.dex.ui.theme.Purple500
import com.arynlyre.dex.ui.theme.Red400
import com.arynlyre.dex.ui.theme.Yellow400
import kotlinx.coroutines.launch

@Composable
fun PokemonBaseStats(
    modifier: Modifier = Modifier,
    stats: Stats
) {
    Column(modifier) {
        PokemonBaseStat("HP", stats.hp, color = Green400)
        PokemonBaseStat("ATK", stats.attk, color = Red400)
        PokemonBaseStat("DEF", stats.def, color = Blue400)
        PokemonBaseStat("SPATK", stats.spattk, color = Purple500)
        PokemonBaseStat("SPDEF", stats.spdef, color = Pink400)
        PokemonBaseStat("SPEED", stats.speed, color = Yellow400)
    }
}

@Composable
private fun PokemonBaseStat(statName: String, statValue: Int, color: Color) {
    var progress by remember { mutableStateOf(0f) }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.weight(1.5f), text = statName)
        Text(modifier = Modifier.weight(1f), text = statValue.toString(), fontWeight = FontWeight.Bold, textAlign = TextAlign.End)
        AnimatedLinearProgressBar(
            modifier = Modifier
                .weight(7.5f)
                .padding(horizontal = 4.dp),
            progress = progress,
            color = color
        )
    }

    LaunchedEffect(Unit) {
        this.launch { progress = statValue.toStatPercentage() }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonBaseStatsViewPreview() {
    val baseStatsFake = Stats(10, 100, 50, 80, 30, 150)

    PokemonBaseStats(modifier = Modifier.fillMaxWidth(), baseStatsFake)
}
