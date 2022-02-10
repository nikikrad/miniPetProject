package com.example.petproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.petproject.servises.Person
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Person.start()
        Thread.sleep(500)

        val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

    }

    //close application
    private var exit = false
    override fun onBackPressed() {
        if (exit) {
            finish() // finish activity
        } else {
            Toast.makeText(
                this, "Повторите действие для выхода из программы",
                Toast.LENGTH_SHORT
            ).show()
            exit = true
            Handler().postDelayed(Runnable { exit = false }, 3 * 1000)
        }
    }


}