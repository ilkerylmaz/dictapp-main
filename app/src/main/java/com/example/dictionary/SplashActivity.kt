package com.example.dictionary

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DURATION = 2000L // 2 saniye
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_DURATION)
    }
} 