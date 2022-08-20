package com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.databinding.ActivityTripFullStatsBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi
import com.google.android.material.internal.TextWatcherAdapter

class TripFullStatsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTripFullStatsBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: TripFullStatsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val factory = (application as FuelCalcApp).factory
        viewModel = ViewModelProvider(this, factory)[TripFullStatsViewModel::class.java]

        viewModel.getItemById(itemId())
        viewModel.observe(this) {
            initViews(it)

            binding.priceNameEd.doOnTextChanged { text, _, _, _ ->
                binding.saveButton.isEnabled = text != it.name()
            }

            binding.saveButton.setOnClickListener { _ ->
                if (isNameChanged(it.name(), binding.priceNameEd.text.toString())) {
                    updateItem(it.id(), binding.priceNameEd.text.toString())
                    finish()
                }
            }
        }
    }

    private fun itemId() = intent.getLongExtra(ITEM, 0)

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
    }
}