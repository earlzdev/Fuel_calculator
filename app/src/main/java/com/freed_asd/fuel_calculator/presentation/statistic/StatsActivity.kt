package com.freed_asd.fuel_calculator.presentation.statistic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.ActivityStatsBinding
import com.freed_asd.fuel_calculator.presentation.statistic.viewpagerStats.ViewPagerStatsAdapter
import com.google.android.material.tabs.TabLayoutMediator

class StatsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStatsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewPager()
    }

    private fun viewPager() {

        binding.viewpagerStats.adapter = ViewPagerStatsAdapter(this)
        binding.tableLayout.tabIconTint = null

        TabLayoutMediator(binding.tableLayout, binding.viewpagerStats) { tab, pos ->
            when(pos) {
                0 -> {
                    tab.text = "Смешанный режим"
                    tab.setIcon(R.drawable.ic_test1)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                }
                1 -> {
                    tab.text = "Город"
                    tab.setIcon(R.drawable.ic_test2)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                }
                2 -> {
                    tab.text = "Трасса"
                    tab.setIcon(R.drawable.ic_test2)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                }
            }
        }.attach()
    }
}