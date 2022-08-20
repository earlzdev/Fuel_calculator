package com.freed_asd.fuel_calculator.presentation.statistic.trips

import android.content.Intent
import android.content.SyncAdapterType
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTripsBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats.TripFullStatsActivity
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.*
import kotlinx.coroutines.flow.toList

class TripsStatsFragment : BaseFragment<FragmentStatsTripsBinding, TripsStatsViewModel>(), ItemClickListener {

    private lateinit var adapter : StatsRvAdapter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTripsBinding.inflate(inflater, container, false)

    override fun viewModelClass() = TripsStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun onItemDetails(item: PriceDbItemUi) {
        val intent = Intent(requireContext(), TripFullStatsActivity::class.java)
        intent.putExtra(TripFullStatsActivity.ITEM, item.id())
        startActivity(intent)
    }

    private fun initViews() {

        adapter = StatsRvAdapter(this)
        binding.recyclerView.adapter = adapter

        val swipeAction = TouchHelper(adapter, viewModel)
        val helper = ItemTouchHelper(swipeAction)
        helper.attachToRecyclerView(binding.recyclerView)
        viewModel.itemList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {

        fun newInstance() = TripsStatsFragment()
    }
}