package com.freed_asd.fuel_calculator.presentation.consumption.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsumptionBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsumptionValidation
import com.freed_asd.fuel_calculator.presentation.consumption.screens.dialog.ConsumptionDialogFragment

class ConsumptionFragment : BaseFragment<FragmentBaseConsumptionBinding, ConsFragViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsumptionBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsFragViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validation = ConsumptionValidation.Base(
            binding.etCurrentMileage,
            binding.etPreviousMileage,
            binding.etFilledFuel
        )

        binding.calcButton.setOnClickListener { calculate(validation)
        viewModel.observe(viewLifecycleOwner, ::openResultDialog)
        }
    }

    fun calculate(validation: ConsumptionValidation.Base) {
        if (validation.validate()) {
            val input = ConsInputUi.Base(
                binding.etCurrentMileage.text.toString().toFloat(),
                binding.etPreviousMileage.text.toString().toFloat(),
                binding.etFilledFuel.text.toString().toFloat()
            )
            viewModel.calculate(input)
        }
    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>) {
        val result = resultEvent.value ?: return
        ConsumptionDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ConsumptionDialogFragment.TAG
        )
    }

    companion object {

        fun newInstance() = ConsumptionFragment()
    }
}