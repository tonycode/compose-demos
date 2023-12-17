package dev.tonycode.demos.jpcompose.ui.screens.courses

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


val dummyCourses: ImmutableList<Course> = persistentListOf(
    Course(
        id = 1,
        title = "English grammar - B1",
        coverUrl = stubCover(24),
        lessons = 52,
        tags = listOf(Tags.LANGUAGES.name, Tags.ENGLISH.name)
    ),
    Course(
        id = 2,
        title = "Advanced English",
        coverUrl = stubCover(26),
        lessons = 64,
        tags = listOf(Tags.LANGUAGES.name, Tags.ENGLISH.name)
    ),
    Course(
        id = 3,
        title = "Learn Japanese - Hiragana (あ-ん)",
        coverUrl = stubCover(82),
        lessons = 48,
        tags = listOf(Tags.LANGUAGES.name, Tags.JAPANESE.name)
    ),
    Course(
        id = 4,
        title = "Docker 101",
        coverUrl = stubCover(951),
        lessons = 25,
        tags = listOf(Tags.DEVOPS.name)
    ),
    Course(
        id = 5,
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        coverUrl = stubCover(527),
        lessons = 777,
        tags = listOf(Tags.DEVOPS.name)
    ),
)

private fun stubCover(imageId: Int) = "https://picsum.photos/id/$imageId/1024"


enum class Tags {
    LANGUAGES,
    ENGLISH,
    JAPANESE,
    DEVOPS,
}
