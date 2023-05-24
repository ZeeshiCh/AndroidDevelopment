package com.example.databindingusingnavgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate() called in Main Activity")
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onStart() {
        super.onStart()
        println("onStart() called in Main Activity")
    }

    override fun onResume(){
        super.onResume()
        println("onResume() called in Main Activity")
    }

    override fun onStop() {
        super.onStop()
        println("onStop() called in Main Activity")
    }

    override fun onRestart(){
        super.onRestart()
        println("onRestart() called in Main Activity")
    }

    override fun onPause(){
        super.onPause()
        println("onPause() called in Main Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy() called in Main Activity")
    }




}