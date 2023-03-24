plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = AndroidSdk.compile

    defaultConfig {
        applicationId = "com.mindbody.countrylist"
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.mindbody.countrylist"
}

dependencies {
    implementation(Libraries.ktxCore)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeUiToolingPreview)
    implementation(Libraries.lifecycleRuntimeKtx)
    implementation(Libraries.activityCompose)

    //Hilt
    implementation(Libraries.hilt)
    kapt(Libraries.hiltCompiler)

    // Navigation
    implementation(Libraries.navigationCompose)
    implementation(Libraries.hiltNavigationCompose)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGsonConverter)

    // Coil
    implementation(Libraries.coilCompose)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockK)
    testImplementation(TestLibraries.coroutineTest)
    androidTestImplementation(TestLibraries.testExtJunit)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.composeUiTest)

    debugImplementation(Libraries.composeUiTooling)
    debugImplementation(Libraries.composeUiTestMainFest)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
