package dev.tonycode.demos.jpcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
    primary = SilverPhoenix,
    primaryVariant = GhostWhite,
    secondary = Walrus,
    onSecondary = GhostWhite,
    secondaryVariant = Tamahagane,
    background = PianoBlack,
    onBackground = GhostWhite,
    surface = Tamahagane,
    onSurface = GhostWhite,
)

private val LightColorPalette = lightColors(
    primary = DepthOfNight,
    primaryVariant = PianoBlack,
    secondary = Walrus,
    onSecondary = GhostWhite,
    secondaryVariant = DiscoBall,
    background = GhostWhite,
    onBackground = PianoBlack,
    surface = SilverPhoenix,
    onSurface = PianoBlack,
)


@Composable
fun DemosAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography(),
        shapes = Shapes,
        content = content
    )
}
