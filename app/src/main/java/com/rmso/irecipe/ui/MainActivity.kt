package com.rmso.irecipe.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rmso.irecipe.ui.theme.IRecipeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ANIMATION_DURATION = 500L

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onStart()
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.uiState.value.isReady
            }

            setOnExitAnimationListener { screen ->
                val slideUp = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.TRANSLATION_Y,
                    0f,
                    -screen.iconView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = ANIMATION_DURATION
                slideUp.doOnEnd { screen.remove() }
                slideUp.start()
            }
        }
        setContent {
            IRecipeTheme {
            }
        }
    }
}
