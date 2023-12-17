package dev.tonycode.demos.jpcompose.ui.screens.profile

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.views.ArcProgressView


@Composable
fun ProfileProgress(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) value: Double,
) {

    val colorPrimary: Int = MaterialTheme.colors.primary.toArgb()
    val colorSecondary: Int = MaterialTheme.colors.secondaryVariant.toArgb()

    AndroidView(
        modifier = modifier.aspectRatio(1f),
        factory = { context ->
            ArcProgressView(context).apply {
                startAngle = (-180 - 45).toFloat()
                sweepAngle = (45 + 180 + 45).toFloat()

                trackWidth = 8.dp.value
                trackColor = colorSecondary
                progressWidth = 8.dp.value
                progressColor = colorPrimary

                progress = value.toFloat()
            }
        }
    )

}

@LightDarkPreviews
@Composable
fun PreviewProfileProgress() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ProfileProgress(value = dummyProfile.achievements.progress)
        }
    }
}
