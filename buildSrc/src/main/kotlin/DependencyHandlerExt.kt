
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addCoreDependencies()  {

    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)
    implementation(Libs.Androidx.Ktx.core)
    // collection ktx
    implementation(Libs.Androidx.Ktx.collection)
    implementation(Libs.Androidx.constraintLayout)
    implementation(Libs.Androidx.Ktx.core)
    implementation(Libs.material)
    implementation(Libs.Androidx.appCompat)
    implementation(Libs.Androidx.swipeRefreshLayout)
    //lifecycle
    implementation(Libs.Androidx.Lifecycle.viewModel)
    implementation(Libs.Androidx.Lifecycle.viewModelSavedState)
    kapt(Libs.Androidx.Lifecycle.compiler)
    //glide
    implementation(Libs.Glide.glideCore)
    kapt(Libs.Glide.compiler)

    //timber
    implementation(Libs.timber)

    // // hilt
    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.Coroutines.coroutinesCore)
    implementation(Libs.Coroutines.android)

    testImplementation(Libs.TestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.espresso)
}


/*
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 * They are used here to provide above dependency syntax that mimics Gradle Kotlin DSL
 * syntax in module\build.gradle.kts files.
 */
@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

private fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)