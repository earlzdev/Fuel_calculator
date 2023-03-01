package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityStatsTripsBinding

class TripsStatsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStatsTripsBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.main -> {
            finish()
            true
        }
        else -> {
            false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.my_trips_action_bar)
        init(TripStatsFragment.newInstance())
    }

    private fun init(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.price_stats_container, fragment)
            .commit()
    }
}