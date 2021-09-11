// gradle version catalog
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("ONE_LOCKFILE_PER_PROJECT")

rootProject.also {
    it.name = "OpenLibrary"
    it.buildFileName = "build.gradle.kts"
}

// include application modules
include(
    ":app",
    ":core",
    ":data",
    ":domain",
    ":model"
)

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

@Suppress("detekt.StringLiteralDuplication")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    // versions catalog
//    versionCatalogs {
//        create("Libs") {
//            version("","")
//            alias("").to("","").versionRef()
//        }
//    }
}
