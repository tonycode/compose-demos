package dev.tonycode.demos.jpcompose.util

import dev.tonycode.demos.jpcompose.BuildConfig


fun getBuildInfo(): String {
    return "${BuildConfig.APP_NAME} v${BuildConfig.VERSION_NAME}" +
        " (" +
        "#${BuildConfig.VERSION_CODE}" +
        ", git: ${BuildConfig.GIT_BRANCH_NAME}@${BuildConfig.GIT_COMMIT_ID}" +
        ", built on ${BuildConfig.BUILD_TIME}" +
        ")"
}
