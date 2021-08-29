import configuration.BuildType
import configuration.ReleaseBuildType
import configuration.DebugBuildType

plugins {
    androidApplication()
    kotlinAndroid()
    kotlinKapt()
    navigationSafeArgs()
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

    compileOptions {
        JavaVersion.VERSION_1_8.apply {
            sourceCompatibility = this
            targetCompatibility = this
        }

    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.Androidx.Ktx.core)
    implementation(Libs.Androidx.appCompat)
    implementation(Libs.MATERIAL)
    testImplementation(Libs.TestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.junit)
    androidTestImplementation(Libs.AndroidTestLibs.espresso)
}
