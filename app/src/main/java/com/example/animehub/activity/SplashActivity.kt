package com.example.animehub.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.animehub.R

class SplashActivity : AppCompatActivity() {

    private val splashDelay: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Start the main activity here
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, splashDelay)
    }
}
