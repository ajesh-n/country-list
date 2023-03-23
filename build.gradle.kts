// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version Versions.androidGradlePlugin apply false
    id("com.android.library") version Versions.androidGradlePlugin apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinStdlib apply false
    id("com.google.dagger.hilt.android") version Versions.hiltVersion apply false
}

tasks.register("clean").configure {
    delete("$rootProject . $buildDir")
}