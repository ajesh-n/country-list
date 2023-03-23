object AndroidSdk {
    const val min = 26
    const val compile = 33
    const val target = compile
}

object Versions {
    const val ktx = "1.7.0"
    const val lifecycleRuntimeKtx = "2.3.1"
    const val composeVersion = "1.4.0"

    // Test
    const val junit4 = "4.13.2"
    const val androidXJunit = "1.1.5"
    const val espresso = "3.5.1"
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
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.androidXJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
}