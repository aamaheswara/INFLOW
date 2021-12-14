package com.glasgow.inflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun fToProfile(view: View){
        val myIntent = Intent(this, UserProfileActivity::class.java)
        startActivity(myIntent)
    }
}