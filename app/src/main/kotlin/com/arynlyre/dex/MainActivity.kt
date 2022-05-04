package com.arynlyre.dex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.arynlyre.dex.ui.list.PokemonListScreen
import com.arynlyre.dex.ui.theme.MVVMComposeTemplateTheme
import com.arynlyre.dex.ui.theme.Red400
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(Red400)

            MVVMComposeTemplateTheme {
                Navigator(PokemonListScreen()) { navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}
