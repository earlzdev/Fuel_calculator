package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.FreedAsd.fuel_calculator.core.BaseFragment
import com.FreedAsd.fuel_calculator.core.Event
import com.FreedAsd.fuel_calculator.databinding.FragmentBasePriceBinding
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceInputDataUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceResultUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.Validation
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views.dialog.ResultDialogFragment

class PriceFragment :
    BaseFragment<FragmentBasePriceBinding, PriceFragmentViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBasePriceBinding = FragmentBasePriceBinding.inflate(
        inflater,
        container,
        false
    )

    override fun viewModelClass() = PriceFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validation = Validation.Base(
            binding.etAverageFuelConsumption,
            binding.etDistance,
            binding.etFuelPrice
        )

        binding.calcPriceButton.setOnClickListener { calculate(validation) }
        viewModel.observe(viewLifecycleOwner, ::openResultDialog)
    }

    private fun calculate(validation: Validation) {
        if (validation.validate()) {
            val inputData = PriceInputDataUi(
                binding.etAverageFuelConsumption.text.toString().toFloat(),
                binding.etDistance.text.toString().toFloat(),
                binding.etFuelPrice.text.toString().toFloat(),
                binding.etCountOfPassengers.text.toString().toFloat()
            )
            viewModel.calculateAnswer(inputData)
        }
    }

    private fun openResultDialog(resultEvent: Event<PriceResultUi>) {
        val result = resultEvent.value ?: return
        ResultDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ResultDialogFragment.TAG
        )
    }

    companion object {
        fun newInstance() = PriceFragment()
    }
}