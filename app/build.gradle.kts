import configuration.BuildType
import configuration.DebugBuildType
import configuration.ReleaseBuildType

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
    navigationSafeArgs()
    daggerHilt()
}

android {
    compileSdk = ProjectConfiguration.COMPILE_SDK
    defaultConfig {
        applicationId = ProjectConfiguration.APPLICATION_ID
        minSdk = ProjectConfiguration.MIN_SDK
        targetSdk = ProjectConfiguration.TARGET_SDK
        versionCode = ProjectConfiguration.VERSION_CODE
        versionName = ProjectConfiguration.VERSION_NAME
        testInstrumentationRunner = ProjectConfiguration.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.Release) {
            isMinifyEnabled = ReleaseBuildType.isMinifyEnabled
            isTestCoverageEnabled = ReleaseBuildType.isTestCoverageEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        getByName(BuildType.Debug) {
            isMinifyEnabled = DebugBuildType.isMinifyEnabled
            isTestCoverageEnabled = DebugBuildType.isTestCoverageEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            applicationIdSuffix = DebugBuildType.applicationIdSuffix
            versionNameSuffix = DebugBuildType.versionNameSuffix
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.Androidx.Ktx.core)
    implementation(Libs.Androidx.appCompat)
    implementation(Libs.material)
    implementation(Libs.Androidx.constraintLayout)
    testImplementation(Libs.TestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.espresso)
    // app startup
    implementation(Libs.Androidx.appStartup)
    implementation(Libs.timber)
    // dagger hilt
    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)
    // retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.moshiKotlin)
    implementation(Libs.Retrofit.retrofitMoshiConverter)

    // okhttp
    implementation(Libs.Okhttp.okhttpCore)
    implementation(Libs.Okhttp.loggingInterceptor)
    // chucker
    debugImplementation(Libs.CommonInterceptors.Chucker.debug)
    releaseImplementation(Libs.CommonInterceptors.Chucker.release)
    // ok2curl
    implementation(Libs.CommonInterceptors.ok2curl)

    // coroutines
    implementation(Libs.Coroutines.coroutinesCore)
    testImplementation(Libs.Coroutines.test)
}
