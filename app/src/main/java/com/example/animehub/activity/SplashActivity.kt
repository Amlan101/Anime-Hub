package com.example.animehub.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.animehub.R


class SplashActivity : AppCompatActivity() {

    private val splashDelay: Long = 4000
    private lateinit var imgSplashIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imgSplashIcon = findViewById(R.id.img_splash_icon)

        // Start the animation for the splash icon
        val fadeAnimation = ObjectAnimator.ofFloat(imgSplashIcon, "alpha", 0f, 1f)
        fadeAnimation.duration = 2000 // 2 second
        fadeAnimation.start()

        Handler().postDelayed({
            // Start the main activity here
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, splashDelay)
    }
}
