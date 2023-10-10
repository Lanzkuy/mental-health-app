package com.example.mental_health_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mental_health_app.presentation.GetStartedFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, GetStartedFragment(), null)
                .commit()
        }
    }
}