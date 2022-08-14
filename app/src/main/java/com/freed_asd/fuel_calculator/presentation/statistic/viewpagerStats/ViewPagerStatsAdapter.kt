package com.freed_asd.fuel_calculator.presentation.statistic.viewpagerStats

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.MileageStatsFragment
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripStatsFragment

class ViewPagerStatsAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = SCREENS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MileageStatsFragment.newInstance()
            else -> TripStatsFragment.newInstance()
        }
    }

    companion object {
        private const val SCREENS_COUNT = 2
    }
}