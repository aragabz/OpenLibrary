package com.ragabz.openlibrary

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class OpenLibraryApp : Application() {

    override fun onCreate() {
        super.onCreate()

        /** init timber initalizer from code or from manifest
         *  AppInitializer.getInstance(this).initializeComponent(TimberInitializer::class.java)
         */
    }
}