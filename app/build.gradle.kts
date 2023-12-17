import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.grgit)
}


android {
    namespace = "dev.tonycode.demos.jpcompose"

    defaultConfig {
        applicationId = "dev.tonycode.demos.jpcompose"
        versionCode = 1
        versionName = "1.0.0"
        archivesName = "compose-demos-v$versionName-build_$versionCode"

        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        resourceConfigurations.addAll(listOf("en"))

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // build info
        buildConfigField("String", "APP_NAME", "\"${ rootProject.name }\"")
        buildConfigField("String", "GIT_BRANCH_NAME", "\"${ grgit.branch.current().name }\"")
        buildConfigField("String", "GIT_COMMIT_ID", "\"${ grgit.head().abbreviatedId }\"")
        buildConfigField("String", "BUILD_TIME", "\"${
            SimpleDateFormat("yyyy.MM.dd EEE 'at' HH:mm:ss.SSS z").apply {
                timeZone = TimeZone.getTimeZone("GMT")
            }.format(Date(System.currentTimeMillis()))
        }\"")
        buildConfigField("long", "BUILD_TIME_MILLIS", "${ System.currentTimeMillis() }L")
    }

    compileSdk = libs.versions.compileSdk.get().toInt()
    buildToolsVersion = libs.versions.buildTools.get()

    sourceSets {
        all {
            kotlin.srcDir("src/$name/kotlin")
        }
    }
    compileOptions {
        //isCoreLibraryDesugaringEnabled = true  // requires multidex
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompilerExtension.get()
    }


    signingConfigs {
        create("release") {
            storeFile = file("../keystore/demo.jks")
            storePassword = "demo12345"
            keyAlias = "key0"
            keyPassword = "demo12345"
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }

        release {
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            // https://developer.android.com/studio/build/shrink-code
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    testCoverage {
        jacocoVersion = libs.versions.jacoco.get()
    }
}

dependencies {
    //// Core
    implementation(platform(libs.kotlin.bom))  // Align versions of all Kotlin components
    implementation(libs.kotlin.stdlib.jdk8)  // Use the Kotlin standard library
    implementation(libs.androidx.core.ktx)

    //// UI
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.constraintLayout.compose)

    implementation(libs.tonycode.arcProgressView)

    //// Debug
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    //// Unit tests
    testImplementation(libs.junit)

    //// Automated ui tests
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(libs.androidx.compose.ui.test.junit)
}
