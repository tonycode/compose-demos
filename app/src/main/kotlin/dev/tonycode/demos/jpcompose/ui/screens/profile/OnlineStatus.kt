package dev.tonycode.demos.jpcompose.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
fun OnlineStatus(
    modifier: Modifier = Modifier,
    isOnline: Boolean,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // an indicator
        Surface(
            modifier = Modifier.padding(top = 3.dp).size(10.dp),
            shape = CircleShape,
            color = if (isOnline) Color.Green else Color.Gray,
        ) { }

        Spacer(Modifier.width(4.dp))

        Text(
            text = stringResource(
                if (isOnline) R.string.online else R.string.offline
            ),
            style = MaterialTheme.typography.body2,
            color = if (isOnline) MaterialTheme.colors.primaryVariant
                else MaterialTheme.colors.secondary,
        )
    }

}

@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewOnlineStatus() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                OnlineStatus(isOnline = true)

                Spacer(Modifier.height(4.dp))

                OnlineStatus(isOnline = false)
            }
        }
    }
}
