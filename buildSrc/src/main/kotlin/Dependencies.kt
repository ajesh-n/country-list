object AndroidSdk {
    const val min = 26
    const val compile = 33
    const val target = compile
}

object Versions {
    const val androidGradlePlugin = "7.4.2"
    const val kotlinStdlib = "1.8.0"

    const val ktx = "1.7.0"
    const val lifecycleRuntimeKtx = "2.3.1"
    const val composeVersion = "1.4.0"

    // Hilt
    const val hiltVersion: String = "2.44"

    // Navigation
    const val navigationComposeVersion: String = "2.5.3"
    const val hiltNavigationComposeVersion: String = "1.0.0"

    // Retrofit
    const val retrofitVersion = "2.9.0"

    // Coil
    const val coil = "2.2.2"

    // Coroutines
    const val coroutines = "1.6.4"

    // Test
    const val junit4 = "4.13.2"
    const val androidXJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val mockkVersion = "1.13.4"
}

object Libraries {
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.composeVersion}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeUiTestMainFest =
        "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"

    // Navigation
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // Coil
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.androidXJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val mockK = "io.mockk:mockk:${Versions.mockkVersion}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}