package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityStatsTripsBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats.TripFullStatsFragment
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.*

class TripsStatsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStatsTripsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init(TripStatsFragment.newInstance())
    }

    private fun init(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.price_stats_container, fragment)
            .commit()
    }
}