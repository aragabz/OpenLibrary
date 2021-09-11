plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
    daggerHilt()
    kotlinParcelize()
}

android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
    }

    buildTypes {
        getByName(configuration.BuildType.Release) {
            isMinifyEnabled = configuration.ReleaseBuildType.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName(configuration.BuildType.Debug) {
            isMinifyEnabled = configuration.DebugBuildType.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    with(JavaVersion.VERSION_1_8) {
        val javaVersion = this

        // compile options
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }

        // kotlin options
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }

    }
}

dependencies {

    api(project(":model"))
    api(project(":core"))

    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)
    implementation(Libs.Androidx.Ktx.core)


    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.Coroutines.coroutinesCore)
    implementation(Libs.Coroutines.android)
    implementation(Libs.timber)
}