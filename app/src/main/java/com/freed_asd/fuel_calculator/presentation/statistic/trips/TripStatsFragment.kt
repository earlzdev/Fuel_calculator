package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.view.LayoutInflater
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTripsBinding

class TripStatsFragment : BaseFragment<FragmentStatsTripsBinding, TripStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTripsBinding.inflate(inflater, container, false)

    override fun viewModelClass() = TripStatsViewModel::class.java

    companion object {

        fun newInstance() = TripStatsFragment()
    }
}