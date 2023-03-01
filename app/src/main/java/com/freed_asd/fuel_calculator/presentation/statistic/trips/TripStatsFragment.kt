package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.presentation.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTripBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.SavedTripPriceUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats.TripFullStatsFragment
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.ItemClickListener
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.StatsRvAdapter
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.TouchHelper

class TripStatsFragment: BaseFragment<FragmentStatsTripBinding, TripsStatsViewModel>(), ItemClickListener {

    private lateinit var adapter : StatsRvAdapter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTripBinding.inflate(inflater, container, false)

    override fun viewModelClass(): Class<TripsStatsViewModel> = TripsStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAllDbValues()
        initViews()
    }

    override fun onItemDetails(item: SavedTripPriceUi) {
        val fragment = TripFullStatsFragment.newInstance(item.id())
        parentFragmentManager.beginTransaction()
            .replace(R.id.price_stats_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun initViews() {
        adapter = StatsRvAdapter(this)
        binding.recyclerView.adapter = adapter
        val swipeAction = TouchHelper(adapter, viewModel)
        val helper = ItemTouchHelper(swipeAction)
        helper.attachToRecyclerView(binding.recyclerView)
        viewModel.observeTripPriceLiveData(this) {
            adapter.submitList(it)
            binding.recyclerListIsEmpty.isVisible = it.isEmpty()
        }
    }

    companion object {
        fun newInstance() = TripStatsFragment()
    }
}