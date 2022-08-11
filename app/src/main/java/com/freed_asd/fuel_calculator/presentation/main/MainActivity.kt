package com.freed_asd.fuel_calculator.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityMainBinding
import com.freed_asd.fuel_calculator.presentation.main.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewPager()
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
}