package com.example.chalenge1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
class SplashActivity : Activity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        handler = Handler()
        handler.postDelayed({
            //val intent = Intent(this@SplashActivity, MainActivity::class.java)
            //startActivity(intent)
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 3000)
    }
}