package dev.tonycode.demos.jpcompose.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.tonycode.demos.jpcompose.R
import dev.tonycode.demos.jpcompose.ui.Symbols
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview


@Composable
fun ProfileScreen(
    profile: UserProfile,
) {

    Column(
        modifier = Modifier.padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AvatarWithProgress(profile)

        Text(
            text = profile.displayName,
            style = MaterialTheme.typography.h5,
        )

        Spacer(Modifier.height(8.dp))

        LevelsBlock(profile)

        Spacer(Modifier.height(8.dp))

        OnlineStatus(isOnline = profile.isOnline)

        Spacer(Modifier.height(24.dp))

        CountersBlock(profile)
    }

}

@Composable
private fun AvatarWithProgress(profile: UserProfile) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        ProfileProgress(
            value = profile.achievements.progress,
            modifier = Modifier.size(88.dp),
        )
        Image(
            painterResource(R.drawable.avatar_placeholder),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
        )
    }
}

@Composable
private fun LevelsBlock(profile: UserProfile) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        PointsView(
            titleRes = R.string.level,
            value = profile.achievements.level,
        )

        Spacer(Modifier.width(8.dp))
        Text(text = Symbols.middleDot)
        Spacer(Modifier.width(8.dp))

        PointsView(
            titleRes = R.string.points,
            value = profile.achievements.points,
            valueColor = Color.Red,
        )
    }
}

@Composable
private fun CountersBlock(profile: UserProfile) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (publications, followers, following) = createRefs()

        CounterView(
            titleRes = R.string.publications,
            value = profile.counters.publications,
            modifier = Modifier.constrainAs(publications) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(followers.start)
                bottom.linkTo(parent.bottom)
            }
        )

        CounterView(
            titleRes = R.string.followers,
            value = profile.counters.followers,
            modifier = Modifier.constrainAs(followers) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )

        CounterView(
            titleRes = R.string.following,
            value = profile.counters.following,
            modifier = Modifier.constrainAs(following) {
                start.linkTo(followers.end)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}


@LightDarkPreviews
@RtlLocalePreview
@Composable
private fun PreviewProfileScreen() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ProfileScreen(profile = dummyProfile)
        }
    }
}
