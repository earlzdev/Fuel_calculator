package com.FreedAsd.fuel_calculator.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.FreedAsd.fuel_calculator.R
import com.FreedAsd.fuel_calculator.presentation.distance.screens.DistanceFragment
import com.FreedAsd.fuel_calculator.presentation.tripPrice.screens.PriceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            showFragment(DistanceFragment.newInstance())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}