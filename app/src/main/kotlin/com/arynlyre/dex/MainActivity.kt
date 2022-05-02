package com.arynlyre.dex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.arynlyre.dex.ui.list.PokemonListScreen
import com.arynlyre.dex.ui.theme.MVVMComposeTemplateTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMComposeTemplateTheme {
                Navigator(PokemonListScreen()) { navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}
