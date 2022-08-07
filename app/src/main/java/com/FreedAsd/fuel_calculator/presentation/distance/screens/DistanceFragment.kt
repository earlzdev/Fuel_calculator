package com.FreedAsd.fuel_calculator.presentation.distance.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.FreedAsd.fuel_calculator.core.BaseFragment
import com.FreedAsd.fuel_calculator.core.Event
import com.FreedAsd.fuel_calculator.databinding.FragmentBaseDistanceBinding
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceInputUi
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceResultUi
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceValidation
import com.FreedAsd.fuel_calculator.presentation.distance.screens.dialog.DistanceDialogFragment

class DistanceFragment : BaseFragment<FragmentBaseDistanceBinding, DistanceViewModel>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentBaseDistanceBinding {
        return FragmentBaseDistanceBinding.inflate(inflater, container, false)
    }

    override fun viewModelClass() = DistanceViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validation = DistanceValidation.Base(
            binding.etAverageFuelConsumption,
            binding.amountOfFuelEd,
            binding.etFuelPrice
        )

        binding.calcButton.setOnClickListener { calculate(validation)
            viewModel.observe(viewLifecycleOwner, ::openResultDialog)
        }
    }

    private fun calculate(validation: DistanceValidation.Base) {
        if (validation.validate()) {
            val input = DistanceInputUi.Base(
                binding.etAverageFuelConsumption.text.toString().toFloat(),
                binding.amountOfFuelEd.text.toString().toFloat(),
                binding.amountOfFuelEd.text.toString().toFloat()
            )
            viewModel.calculate(input)
        }
    }

    private fun openResultDialog(resultEvent: Event<DistanceResultUi>) {
        val result = resultEvent.value ?: return
        DistanceDialogFragment.newInstance(result).show(
            parentFragmentManager,
            DistanceDialogFragment.TAG
        )
    }

    companion object {

        fun newInstance() = DistanceFragment()
    }
}