package dev.tonycode.demos.jpcompose.ui.util

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview


private const val GROUP_UI_MODE = "UI mode"
private const val GROUP_LOCALES = "Locales"
private const val GROUP_FONT_SCALES = "Font scales"


@Preview(
    name = "a) Light mode",
    group = GROUP_UI_MODE,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
)
@Preview(
    name = "b) Dark mode",
    group = GROUP_UI_MODE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
)
annotation class LightDarkPreviews


@Preview(
    name = "Hebrew (RTL)",
    group = GROUP_LOCALES,
    locale = "iw",
)
annotation class RtlLocalePreview


@Preview(
    name = "a) Large font",
    group = GROUP_FONT_SCALES,
    fontScale = 1.5f,
)
@Preview(
    name = "b) Small font",
    group = GROUP_FONT_SCALES,
    fontScale = 0.5f,
)
annotation class FontScalePreviews
