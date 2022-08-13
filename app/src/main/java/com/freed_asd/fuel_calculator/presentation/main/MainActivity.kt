package com.freed_asd.fuel_calculator.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityMainBinding
import com.freed_asd.fuel_calculator.presentation.main.viewpager.ViewPagerAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.StatsActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewPager()
        drawer()
    }

    private fun viewPager() {

        binding.viewpager.adapter = ViewPagerAdapter(this)
        binding.tableLayout.tabIconTint = null

        TabLayoutMediator(binding.tableLayout, binding.viewpager) { tab, pos ->
            when(pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_test1)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_test2)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_test3)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
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
                    startActivity(Intent(this, StatsActivity::class.java))
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