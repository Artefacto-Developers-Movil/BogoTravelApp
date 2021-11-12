package com.bogotravel.bogotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class activity_splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        SystemClock.sleep(4000)
        val intent = Intent (this, MainActivity :: class.java )
        startActivity(intent)
    }
}