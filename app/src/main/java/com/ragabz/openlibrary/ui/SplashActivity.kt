package com.ragabz.openlibrary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ragabz.openlibrary.R
import timber.log.Timber

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timber.i("Splash --> onCreate()")
    }
}