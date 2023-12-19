package dev.tonycode.demos.jpcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.tonycode.demos.jpcompose.R
import dev.tonycode.demos.jpcompose.ui.screens.courses.CoursesScreen
import dev.tonycode.demos.jpcompose.ui.screens.courses.dummyCourses
import dev.tonycode.demos.jpcompose.ui.screens.profile.ProfileScreen
import dev.tonycode.demos.jpcompose.ui.screens.profile.dummyProfile
import dev.tonycode.demos.jpcompose.ui.theme.DemosAppTheme
import dev.tonycode.demos.jpcompose.ui.util.LightDarkPreviews
import dev.tonycode.demos.jpcompose.ui.util.RtlLocalePreview


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
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    NavigationBar {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination

                        navItems.forEach { screen ->
                            NavigationBarItem(
                                icon = {
                                    Icon(screen.icon, contentDescription = null)
                                },
                                label = {
                                    Text(stringResource(screen.resourceId))
                                },
                                selected = (currentDestination?.hierarchy?.any { it.route == screen.route } == true),
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                            )
                        }
                    }
                }
            ) { innerPadding ->
                NavHost(navController, startDestination = Screen.Courses.route, Modifier.padding(innerPadding)) {
                    composable(Screen.Courses.route) { CoursesScreen(courses = dummyCourses) }
                    composable(Screen.Profile.route) { ProfileScreen(profile = dummyProfile) }
                }
            }
        }
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Courses : Screen("courses", R.string.courses, Icons.Filled.FolderOpen)
    object Profile : Screen("profile", R.string.profile, Icons.Filled.Person)
}

val navItems = listOf(
    Screen.Courses,
    Screen.Profile
)


@LightDarkPreviews
@RtlLocalePreview
@Composable
fun PreviewDemosApp() {
    DemosApp()
}
