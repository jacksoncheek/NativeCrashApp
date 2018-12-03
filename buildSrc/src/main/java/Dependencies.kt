object Projects {
    val app = ":app"
    val rootbeerlib = ":rootbeerlib"
    val brokenrootbeerlib = ":brokenrootbeerlib"
}

object Versions {
    // Build
    val minSdk = 15
    val targetSdk = 27
    val compileSdk = 27
    val buildTools = "28.0.3"
    val sourceCompat = "1.7"
    val targetCompat = "1.7"
    val versionCode = 1
    val versionName = "1.0"

    // Libs
    val kotlin = "1.3.10"
    val supportLibrary = "27.1.1"
    val constraintLayout = "1.0.2"
    val jUnit = "4.12"
    val androidGradlePlugin = "3.2.1"
    val espresso = "3.0.2"
    val androidTestingSupportLib = "1.0.2"
    val mockito = "2.13.0"
}

object Libs {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val supportAppCompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
    val supportConstraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
}

object TestLibs {
    val jUnit = "junit:junit:${Versions.jUnit}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val androidTestRunner = "com.android.support.test:runner:${Versions.androidTestingSupportLib}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
}

object GradlePlugins {
    val android = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}