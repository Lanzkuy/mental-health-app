package com.example.mental_health_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.mental_health_app.presentation.ChatFragment
import com.example.mental_health_app.presentation.ForumFragment
import com.example.mental_health_app.presentation.GetStartedFragment
import com.example.mental_health_app.presentation.HomeFragment
import com.example.mental_health_app.presentation.SettingsFragment
import com.example.mental_health_app.utils.Communicator
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.navigation)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, GetStartedFragment(), null)
                .commit()
        }

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment(), null)
                        .commit()
                    true
                }

                R.id.nav_chat -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, ChatFragment(), null)
                        .commit()
                    true
                }

                R.id.nav_forum -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, ForumFragment(), null)
                        .commit()
                    true
                }

                R.id.nav_setting -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, SettingsFragment(), null)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }

    override fun sendData(bundle: Bundle, fragment: Fragment, tag: String) {
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}