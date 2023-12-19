package dev.tonycode.demos.jpcompose.ui.screens.courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview
import kotlinx.collections.immutable.ImmutableList
import java.util.TreeSet


@Composable
fun CoursesScreen(
    courses: ImmutableList<Course>
) {

    val tags = TreeSet<String>()
    courses.flatMapTo(tags) { it.tags }

    val selectedTags = remember { mutableStateListOf<String>() }


    Column {
        TagsList(
            tags = tags.toList(),
            selectedTags = selectedTags.toSet(),
            onTagSelected = { selectedTag ->
                selectedTags += selectedTag
            },
            onTagUnselected = { unselectedTag ->
                selectedTags -= unselectedTag
            }
        )

        CoursesList(
            filteredCourses = if (selectedTags.isEmpty()) {
                courses
            } else {
                courses.filter { course ->
                    course.tags.any { tag -> selectedTags.contains(tag) }
                }
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TagsList(
    tags: List<String>,
    selectedTags: Set<String>,
    onTagSelected: (tag: String) -> Unit,
    onTagUnselected: (tag: String) -> Unit,
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp /* FilterChip's vertical padding is enough */),
    ) {
        tags.forEach { tag ->
            FilterChip(
                selected = selectedTags.contains(tag),
                onClick = {
                    if (selectedTags.contains(tag)) {
                        onTagUnselected.invoke(tag)
                    } else {
                        onTagSelected.invoke(tag)
                    }
                },
                label = { Text(tag.lowercase()) },
                shape = RoundedCornerShape(percent = 100),
            )
        }
    }
}

@Composable
private fun CoursesList(filteredCourses: List<Course>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)
    ) {
        items(filteredCourses) { course ->
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
