package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.FreedAsd.fuel_calculator.core.BaseFragment
import com.FreedAsd.fuel_calculator.databinding.FragmentBasePriceBinding
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceInputDataUi

class PriceFragment :
    BaseFragment<FragmentBasePriceBinding, TripPriceViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBasePriceBinding = FragmentBasePriceBinding.inflate(
        inflater,
        container,
        false
    )

    override fun viewModelClass() = TripPriceViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calcPriceButton.setOnClickListener {
            viewModel.calculateAnswer(getCalcData())
        }
    }

    private fun getCalcData(): PriceInputDataUi {
        return PriceInputDataUi(
            binding.etAverageFuelConsumption.text.toString().toFloat(),
            binding.etDistance.text.toString().toFloat(),
            binding.etFuelPrice.text.toString().toFloat(),
            binding.etCountOfPassengers.text.toString().toFloat()
        )
    }

    companion object {

        fun newInstance() = PriceFragment()
    }
}