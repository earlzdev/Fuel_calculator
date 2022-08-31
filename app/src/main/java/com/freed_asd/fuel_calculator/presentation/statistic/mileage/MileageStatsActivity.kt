package com.freed_asd.fuel_calculator.presentation.statistic.mileage

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityStatsBinding
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.viewpagerStats.ViewPagerStatsAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MileageStatsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStatsBinding.inflate(layoutInflater)
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

        supportActionBar?.setTitle(R.string.Mileage_history)
        viewPager()
    }

    private fun viewPager() {

        binding.viewpagerStats.adapter = ViewPagerStatsAdapter(this)
        binding.tableLayout.tabIconTint = null

        TabLayoutMediator(binding.tableLayout, binding.viewpagerStats) { tab, pos ->
            when(pos) {
                0 -> {
                    tab.text = MIXED
                }
                1 -> {
                    tab.text = CITY
                }
                2 -> {
                    tab.text = TRACK
                }
            }
        }.attach()
    }

    companion object {

        const val MIXED = "Смешанный"
        const val CITY = "Город"
        const val TRACK = "Трасса"
    }
}