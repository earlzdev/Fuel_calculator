package com.freed_asd.fuel_calculator.presentation.statistic.viewpagerStats

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.CityMileageStatsFragment
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.MixedMileageStatsFragment
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.TrackMileageStatsFragment

class ViewPagerStatsAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = SCREENS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MixedMileageStatsFragment.newInstance()
            1 -> CityMileageStatsFragment.newInstance()
            else -> TrackMileageStatsFragment.newInstance()
        }
    }

    companion object {

        private const val SCREENS_COUNT = 3
    }
}