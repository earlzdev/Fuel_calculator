package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsDistanceBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog.ConsDistanceDialogFragment

class ConsDistanceFragment : BaseFragment<FragmentBaseConsDistanceBinding, ConsDistanceViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsDistanceBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsDistanceViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validation = ConsDistanceValidation.Base(
            binding.etDistance,
            binding.etFilledFuelDistance
        )

        binding.calcButtonDistance.setOnClickListener { calculate(validation)
            viewModel.observe(viewLifecycleOwner, ::openResultDialog)
        }
    }

    private fun calculate(validation: ConsDistanceValidation)  {
        if (validation.validate()) {
            val input = ConsInputUi.Base(
                binding.etDistance.text.toString().toFloat(),
                binding.etFilledFuelDistance.text.toString().toFloat()
            )
            viewModel.calculate(input)
        }
    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>) {
        val result = resultEvent.value ?: return
        ConsDistanceDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ConsDistanceDialogFragment.TAG
        )
    }

    companion object {

        fun newInstance() = ConsDistanceFragment()
    }
}