package dev.tonycode.demos.jpcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
    primary = Palette.SilverPhoenix,
    primaryVariant = Palette.GhostWhite,
    secondary = Palette.Walrus,
    onSecondary = Palette.GhostWhite,
    secondaryVariant = Palette.Tamahagane,
    background = Palette.PianoBlack,
    onBackground = Palette.GhostWhite,
    surface = Palette.Tamahagane,
    onSurface = Palette.GhostWhite,
)

private val LightColorPalette = lightColors(
    primary = Palette.DepthOfNight,
    primaryVariant = Palette.PianoBlack,
    secondary = Palette.Walrus,
    onSecondary = Palette.GhostWhite,
    secondaryVariant = Palette.DiscoBall,
    background = Palette.GhostWhite,
    onBackground = Palette.PianoBlack,
    surface = Palette.SilverPhoenix,
    onSurface = Palette.PianoBlack,
)


@Composable
fun DemosAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography(),
        shapes = Shapes,
        content = content
    )
}
