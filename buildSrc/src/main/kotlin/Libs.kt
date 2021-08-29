object Libs {

    // region Kotlin
    object Kotlin {
        const val version = "1.5.30"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    }
    // endregion

    // region Androidx
    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        const val slidingPaneLayout =
            "androidx.slidingpanelayout:slidingpanelayout:1.2.0-alpha01"

        // fragment test
        const val fragmentTest = "androidx.fragment:fragment-testing:1.3.6"

        // drawer layout
        const val drawerLayout = "androidx.drawerlayout:drawerlayout:1.1.0-rc01"

        // card view
        const val cardview = "androidx.cardview:cardview:1.0.0"

        // browser
        const val browser = "androidx.browser:browser:$1.0.0"

        // app startup
        const val appStartup = "androidx.startup:startup-runtime:1.1.0-beta01"

        // region Benchmark
        object Benchmark {
            const val version = "1.1.0-alpha06"
            const val benchmarkJunit = "androidx.benchmark:benchmark-junit4:$version"
            const val macro =
                "androidx.benchmark:benchmark-macro-junit4:$version"
        }
        // endregion

        // region ktx
        object Datastore {
            private const val version = "1.0.0"
            const val core = "androidx.datastore:datastore:$version"
            const val prederences = "androidx.datastore:datastore-preferences:$version"
        }
        // endregion

        // region Ktx
        object Ktx {
            private const val coreKtxVersion = "1.7.0-alpha01"
            private const val fragmentKtxVersion = "1.3.6"
            private const val collectionKtxVersion = "1.2.0-alpha01"
            private const val activityKtxVersion = "1.2.0-rc01"

            const val core = "androidx.core:core-ktx:$coreKtxVersion"
            const val fragment = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
            const val collection = "androidx.collection:collection-ktx:$collectionKtxVersion"
            const val activity = "androidx.activity:activity-ktx:$activityKtxVersion"
        }
        // endregion

        // region Lifecycle
        object Lifecycle {
            private const val version = "2.4.0-alpha01"

            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }
        // endregion
    }
    // endregion

    //region Okhttp
    object Okhttp {
        private const val version = "3.10.0"

        const val okhttpCore = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }
    // endregion

    // region Glide
    object Glide {
        private const val version = "4.9.0"
        const val glideCore = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }
    // endregion

    // region Coroutines
    object Coroutines {
        // coroutines
        private const val version = "1.4.2"

        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }
    // endregion

    // region Navigation
    object Navigation {
        const val version = "2.4.0-alpha07"
        const val fragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
    }
    // endregion

    // region Room
    object Room {
        private const val version = "2.2.5"

        const val compiler = "androidx.room:room-compiler:$version"
        const val roomKtx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
    }
    // endregion

    // region Hilt
    object Hilt {
        const val version = "2.38.1"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }
    // endregion

    // region Firebase
    object Firebase {
        const val analytics =
            "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"

        const val auth = "com.google.firebase:firebase-auth-ktx:${Versions.firebaseAuth}"

        const val config =
            "com.google.firebase:firebase-config-ktx:${Versions.firebaseConfig}"

        const val firestore =
            "com.google.firebase:firebase-firestore-ktx:${Versions.lifecycle}"

        const val functions =
            "com.google.firebase:firebase-functions-ktx:${Versions.lifecycle}"

        const val messaging =
            "com.google.firebase:firebase-messaging:${Versions.lifecycle}"

        const val uiAuth = "com.firebaseui:firebase-ui-auth:${Versions.lifecycle}"

        const val crashlytics =
            "com.google.firebase:firebase-crashlytics:${Versions.lifecycle}"
    }
    // endregion

    // region Test Libs
    object TestLibs {
        const val junit = "junit:junit:4.13.2"
    }
    // endregion

    // region Android Test Libs
    object AndroidTestLibs {
        const val junit = "androidx.test.ext:junit:1.1.1"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.0-alpha07"
    }
    // endregion

    //region General Libs
    const val MATERIAL = "com.google.android.material:material:1.5.0-alpha02"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.timber}"

    // okio
    const val OKIO = "com.squareup.okio:okio:${Versions.okio}"

    // lottie
    const val LOTTIE = "com.airbnb.android:lottie:${Versions.lottie}"
    const val GSON = "com.google.code.gson:gson:${Versions.gson}"
    const val HAMCREST = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    //endregion
}

