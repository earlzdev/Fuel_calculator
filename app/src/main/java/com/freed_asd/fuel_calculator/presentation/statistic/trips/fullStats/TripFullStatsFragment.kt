package com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentTripFullStatsBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi

class TripFullStatsFragment : BaseFragment<FragmentTripFullStatsBinding, TripFullStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentTripFullStatsBinding.inflate(inflater, container, false)

    override fun viewModelClass(): Class<TripFullStatsViewModel> = TripFullStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getItemById(itemId())
        viewModel.observe(this) {
            initViews(it)

            binding.priceNameEd.doOnTextChanged { text, _, _, _ ->
                binding.saveButton.isEnabled = text != it.name()
            }

            binding.saveButton.setOnClickListener { _ ->
                if (isNameChanged(it.name(), binding.priceNameEd.text.toString())) {
                    updateItem(it.id(), binding.priceNameEd.text.toString())
                }
            }
        }
    }

    private fun itemId() = requireArguments().getLong(ITEM)

    private fun initViews(item: PriceDbItemUi) {
        binding.priceNameEd.setText(item.name())
        binding.priceNeedFuelValue.text = item.needFuel().toString()
        binding.priceDistanceValue.text = item.distance().toString()
        binding.priceGeneralPriceValue.text = item.generalPrice().toString()
        binding.priceEveryonePriceValue.text = item.everyonePrice().toString()
    }

    private fun isNameChanged(oldName: String, newName: String) : Boolean  = oldName != newName

    private fun updateItem(item: Long, newName: String) {
        viewModel.updateItem(item, newName)
    }

    companion object {

        const val TAG = "Full stats fragment tag"
        const val ITEM = "Item"

        fun newInstance(item: Long) = TripFullStatsFragment().apply {
            arguments = bundleOf(ITEM to item)
        }
    }
}