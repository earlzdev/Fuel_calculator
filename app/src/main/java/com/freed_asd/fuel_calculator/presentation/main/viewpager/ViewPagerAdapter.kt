package com.freed_asd.fuel_calculator.presentation.main.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.freed_asd.fuel_calculator.presentation.consumption.screens.ConsumptionBaseFragment
import com.freed_asd.fuel_calculator.presentation.distance.screens.DistanceFragment
import com.freed_asd.fuel_calculator.presentation.price.screens.PriceFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = SCREENS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ConsumptionBaseFragment.newInstance()
            1 -> PriceFragment.newInstance()
            else -> DistanceFragment.newInstance()
        }
    }

    companion object {
        private const val SCREENS_COUNT = 3
    }
}