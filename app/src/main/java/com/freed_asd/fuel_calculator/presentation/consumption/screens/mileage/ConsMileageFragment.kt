package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsMileageBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.ConsMileageDialogFragment

class ConsMileageFragment : BaseFragment<FragmentBaseConsMileageBinding, ConsMileageViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsMileageViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val validation = ConsMileageValidation.Base(
            binding.etCurrentMileage,
            binding.etPreviousMileage,
            binding.etFilledFuel
        )

        binding.calcButton.setOnClickListener { calculate(validation)
            viewModel.observe(viewLifecycleOwner, ::openResultDialog)
        }
    }

    fun calculate(validation: ConsMileageValidation.Base) {
        if (validation.validate()) {
            val distance = binding.etCurrentMileage.text.toString().toFloat() - binding.etPreviousMileage.text.toString().toFloat()
            val input = ConsInputUi.Base(
                distance,
                binding.etFilledFuel.text.toString().toFloat()
            )
            viewModel.calculate(input)
        }
    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>) {
        val result = resultEvent.value ?: return
        ConsMileageDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ConsMileageDialogFragment.TAG
        )
    }

    companion object {

        fun newInstance() = ConsMileageFragment()
    }
}