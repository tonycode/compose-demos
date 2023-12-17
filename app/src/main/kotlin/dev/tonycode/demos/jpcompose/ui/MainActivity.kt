package dev.tonycode.demos.jpcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tonycode.demos.jpcompose.ui.screens.courses.CoursesScreen
import dev.tonycode.demos.jpcompose.ui.screens.courses.dummyCourses
import dev.tonycode.demos.jpcompose.ui.screens.profile.ProfileScreen
import dev.tonycode.demos.jpcompose.ui.screens.profile.dummyProfile
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemosApp()
        }
    }

}

@Composable
fun DemosApp() {
    DemosAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                ProfileScreen(profile = dummyProfile)
                CoursesScreen(courses = dummyCourses)
            }
        }
    }
}

@Preview
@Composable
fun PreviewDemosApp() {
    DemosApp()
}
