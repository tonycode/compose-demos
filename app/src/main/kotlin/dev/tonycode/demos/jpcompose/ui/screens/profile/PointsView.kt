package dev.tonycode.demos.jpcompose.ui.screens.profile

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.tonycode.demos.jpcompose.R
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview


@Composable
fun PointsView(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    value: Int,
    valueColor: Color? = null,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.body2,
            color = valueColor ?: MaterialTheme.colors.primaryVariant,
        )

        Spacer(Modifier.width(6.dp))

        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.secondary
        )
    }

}

@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewPointsView() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            PointsView(
                titleRes = R.string.level,
                value = dummyProfile.achievements.level,
            )
        }
    }
}
