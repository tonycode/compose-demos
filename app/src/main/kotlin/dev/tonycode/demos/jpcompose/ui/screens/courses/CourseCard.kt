package dev.tonycode.demos.jpcompose.ui.screens.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.tonycode.demos.jpcompose.R
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.theme.Palette
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview


@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    course: Course,
) {

    Box(
        modifier = modifier.clip(MaterialTheme.shapes.medium),
    ) {
        // cover
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(course.coverUrl)
                .crossfade(true)
                .build(),
            placeholder = ColorPainter(Palette.Walrus),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        // dimmer
        Box(
            modifier = Modifier.fillMaxSize()
                .background(
                    Brush.verticalGradient(listOf(Color.Transparent, Palette.Oil))
                ),
        )

        // title & lessons
        // nb: long title should go multi-line
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
        ) {
            val (title, lessons) = createRefs()

            Text(
                text = course.title,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start, margin = 12.dp)
                    end.linkTo(lessons.start, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = course.lessons.toString() + " " + stringResource(R.string.lessons),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.constrainAs(lessons) {
                    end.linkTo(parent.end, margin = 12.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                }
            )
        }
    }

}


@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewCourseCard() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            CourseCard(
                course = dummyCourses[0],
                modifier = Modifier.fillMaxWidth()
                    .height(120.dp)
            )
        }
    }
}
