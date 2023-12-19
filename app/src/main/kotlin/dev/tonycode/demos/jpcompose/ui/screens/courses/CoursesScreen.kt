package dev.tonycode.demos.jpcompose.ui.screens.courses

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview
import kotlinx.collections.immutable.ImmutableList


@Composable
fun CoursesScreen(
    courses: ImmutableList<Course>
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)
    ) {
        items(courses) { course ->
            CourseCard(
                course = course,
                modifier = Modifier.fillMaxWidth()
                    .height(120.dp)
                    .padding(bottom = 12.dp)
            )
        }
    }

}


@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewCoursesScreen() {
    DemosAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            CoursesScreen(dummyCourses)
        }
    }
}
