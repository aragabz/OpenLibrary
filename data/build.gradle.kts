import configuration.BuildType

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
        getByName(BuildType.Release) {
            isMinifyEnabled = configuration.ReleaseBuildType.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "baseUrl", configuration.DebugBuildType.baseUrl)
        }

        getByName(BuildType.Debug) {
            isMinifyEnabled = configuration.DebugBuildType.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "baseUrl", configuration.DebugBuildType.baseUrl)
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
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.reflection)
    implementation(Libs.Androidx.Ktx.core)

    api(project(":domain"))
    // hilt
    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation(Libs.Coroutines.coroutinesCore)
    implementation(Libs.Coroutines.android)

    // retrofit
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.gsonConverter)
    implementation(Libs.Okhttp.loggingInterceptor)
    //interceptor
    implementation(Libs.CommonInterceptors.ok2curl)
    debugImplementation(Libs.CommonInterceptors.Chucker.debug)

    implementation(Libs.timber)

}