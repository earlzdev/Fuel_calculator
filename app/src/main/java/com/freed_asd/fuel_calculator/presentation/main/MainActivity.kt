package com.freed_asd.fuel_calculator.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityMainBinding
import com.freed_asd.fuel_calculator.presentation.main.viewpager.ViewPagerAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.MileageStatsActivity
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripsStatsActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewPager()
        drawer()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun viewPager() {

        binding.viewpager.adapter = ViewPagerAdapter(this)
        binding.tableLayout.tabIconTint = null

        binding.tableLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportActionBar?.title = tab?.contentDescription
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
        })

        TabLayoutMediator(binding.tableLayout, binding.viewpager) { tab, pos ->
            when(pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_cons_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_cons_toolbar)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_price_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_price_toolbar)
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_distance_toolbar)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.contentDescription = getString(R.string.calc_distance_toolbar)
                }
            }
        }.attach()
    }

    private fun drawer() {

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.statistic -> {
                    startActivity(Intent(this, MileageStatsActivity::class.java))
                    drawerLayout.closeDrawers()
                }
                R.id.trips -> {
                    startActivity(Intent(this, TripsStatsActivity::class.java))
                    drawerLayout.closeDrawers()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}