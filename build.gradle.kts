// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    dependencyUpdates()
    ktlint()
    detekt()
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha10")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.Kotlin.version}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${Libs.Androidx.Benchmark.version}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Libs.Navigation.version}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Libs.Hilt.version}")
    }
}
tasks.withType<Delete> {
    delete(rootProject.buildDir)
}
