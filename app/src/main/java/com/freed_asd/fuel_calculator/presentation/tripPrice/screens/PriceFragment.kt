package com.freed_asd.fuel_calculator.presentation.tripPrice.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBasePriceBinding
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceInputDataUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.TripValidation
import com.freed_asd.fuel_calculator.presentation.tripPrice.screens.dialog.ResultDialogFragment

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

        val validation = TripValidation.Base(
            binding.etAverageFuelConsumption,
            binding.etDistance,
            binding.etFuelPrice,
        )

        binding.calcPriceButton.setOnClickListener { calculate(validation) }
        viewModel.observe(viewLifecycleOwner, ::openResultDialog)
    }

    private fun calculate(validation: TripValidation) {
        if (validation.validate()) {
            val inputData = PriceInputDataUi(
                binding.etAverageFuelConsumption.text.toString().toFloat(),
                binding.etDistance.text.toString().toFloat(),
                binding.etFuelPrice.text.toString().toFloat(),
                isPassengersCountValid(binding.etCountOfPassengers)
            )
            viewModel.calculateAnswer(inputData)
        }
    }

    private fun isPassengersCountValid(passengers: EditText): Float {
        return when {
            passengers.text.isEmpty() -> 1f
            else -> passengers.text.toString().toFloat()
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