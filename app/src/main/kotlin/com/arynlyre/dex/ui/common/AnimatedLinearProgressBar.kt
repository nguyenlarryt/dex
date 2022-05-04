package com.arynlyre.dex.ui.common

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arynlyre.dex.ui.theme.Green400

@Composable
fun AnimatedLinearProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color = Green400
) {
    val progressAnimDuration = 800
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = progressAnimDuration,
            easing = FastOutSlowInEasing
        )
    )
    Box(modifier) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .clip(CircleShape),
            color = color,
            progress = progressAnimation
        )
    }
}

@Preview
@Composable
fun ProgressBarPreview() {
    AnimatedLinearProgressBar(progress = 2f)
}
