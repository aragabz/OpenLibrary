plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinKapt()
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    with(JavaVersion.VERSION_1_8) {
        val javaVersion = this
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }

    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation(Libs.Androidx.Ktx.core)
    implementation(Libs.Androidx.appCompat)
    implementation(Libs.material)
    implementation(Libs.Androidx.swipeRefreshLayout)
    implementation(Libs.Glide.glideCore)
    kapt(Libs.Glide.compiler)
    kapt(Libs.Androidx.recyclerview)
    kapt(Libs.Androidx.recyclerviewSelection)

    implementation(Libs.Androidx.Lifecycle.runtime)
    implementation(Libs.Androidx.Lifecycle.liveData)
    implementation(Libs.Androidx.Lifecycle.viewModel)
    implementation(Libs.Androidx.Lifecycle.common)
    kapt(Libs.Androidx.Lifecycle.compiler)
}