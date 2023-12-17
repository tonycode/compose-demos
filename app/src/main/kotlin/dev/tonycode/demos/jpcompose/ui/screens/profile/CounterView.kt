package dev.tonycode.demos.jpcompose.ui.screens.profile

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.tonycode.demos.jpcompose.R
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview


/**
 * Integer value and title stacked vertically
 */
@Composable
fun CounterView(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    value: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onBackground,
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = stringResource(id = titleRes),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.secondary,
        )
    }
}

@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewCounterView() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            CounterView(
                titleRes = R.string.followers,
                value = dummyProfile.counters.followers,
            )
        }
    }
}
