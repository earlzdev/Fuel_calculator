package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatisticBinding
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTripsBinding
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.StatsRvAdapter

class TripsStatsFragment : BaseFragment<FragmentStatsTripsBinding, TripsStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTripsBinding.inflate(inflater, container, false)

    override fun viewModelClass() = TripsStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val itemList = viewModel.testRecyclerItems()
        binding.recyclerView.apply {
            adapter = StatsRvAdapter(itemList)
        }
    }

    companion object {

        fun newInstance() = TripsStatsFragment()
    }
}