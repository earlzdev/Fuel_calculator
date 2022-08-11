package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsMileageBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.ConsMileageDialogFragment

class ConsMileageFragment : BaseFragment<FragmentBaseConsMileageBinding, ConsMileageViewModel>(), AdapterView.OnItemSelectedListener {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsMileageViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner()
        shouldAddIntoStats()

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

    private fun initSpinner() {

        val driveRegimeSpinner = binding.spinnerDriveRegime
        driveRegimeSpinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_drive_regime,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            driveRegimeSpinner.adapter = adapter
        }
    }

    private fun shouldAddIntoStats() {

        binding.checkSetStats.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.drivingRegime.isVisible = true
                binding.spinnerDriveRegime.isVisible = true
            } else {
                binding.drivingRegime.isVisible = false
                binding.spinnerDriveRegime.isVisible = false
            }
        }
    }

    private fun setResultIntoStats() {



    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>) {
        val result = resultEvent.value ?: return
        ConsMileageDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ConsMileageDialogFragment.TAG
        )
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    companion object {

        fun newInstance() = ConsMileageFragment()
    }
}