package com.glasgow.inflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNav)

        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }

    private val onBottomNav = BottomNavigationView.OnNavigationItemSelectedListener {i ->
        var selectedFragment: Fragment = HomeFragment()

        when(i.itemId){
            R.id.item_home -> {
                selectedFragment = HomeFragment()
            }

            R.id.item_search -> {
                selectedFragment = SearchFragment()
            }

            R.id.item_account -> {
                selectedFragment = ProfileFragment()
            }
        }

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment, selectedFragment)
        fr.commit()

        true
    }
}