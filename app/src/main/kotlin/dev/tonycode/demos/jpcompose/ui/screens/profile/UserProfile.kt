package dev.tonycode.demos.jpcompose.ui.screens.profile


data class UserProfile(

    val firstName: String,

    val lastName: String,

    val avatarUrl: String?,

    val isOnline: Boolean,

    val achievements: UserAchievements,

    val counters: UserCounters

) {

    val displayName: String = "$firstName $lastName"

}

data class UserAchievements(

    val level: Int,

    val points: Int,

    val progress: Double,

    )

data class UserCounters(

    val publications: Int,

    val followers: Int,

    val following: Int

)


val dummyProfile = UserProfile(
    firstName = "Max",
    lastName = "Tantum",
    avatarUrl = null,

    isOnline = true,

    achievements = UserAchievements(
        level = 21,
        points = 12345,
        progress = 1 / 3.0,
    ),

    counters = UserCounters(
        publications = 10,
        followers = 123,
        following = 50,
    ),
)
