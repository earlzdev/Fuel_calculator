package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsMileageBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.ConsMileageDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ConsMileageFragment : BaseFragment<FragmentBaseConsMileageBinding, ConsMileageViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsMileageViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner()
        showRegimeSpinner()

        val validation = ConsMileageValidation.Base(
            binding.etCurrentMileage,
            binding.etPreviousMileage,
            binding.etFilledFuel
        )

        val shouldAddIntoStats = ShouldAddIntoStats.Base(
            binding.checkSetStats
        )

        binding.calcButton.setOnClickListener {
            calculate(validation)
            lifecycleScope.launch {
                setIntoStats(shouldAddIntoStats)
            }
        }
        viewModel.observe(viewLifecycleOwner) { openResultDialog(it, shouldAddIntoStats) }
    }

    private fun calculate(validation: ConsMileageValidation.Base) {
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
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_drive_regime,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            driveRegimeSpinner.adapter = adapter
        }
    }

    private fun showRegimeSpinner() {

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

    private fun setIntoStats(check: ShouldAddIntoStats.Base) {

        if (check.shouldlAddIntoStats()) {
            val driveRegime = binding.spinnerDriveRegime.selectedItem.toString()
            val mileage = binding.etCurrentMileage.text.toString().toFloat()
            viewModel.setIntoStats(driveRegime, mileage)
        }
    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>, checkSetStats: ShouldAddIntoStats.Base) {

        val shouldSetIntoStats = checkSetStats.shouldlAddIntoStats()
        val result = resultEvent.value ?: return
        ConsMileageDialogFragment.newInstance(result, shouldSetIntoStats).show(
            parentFragmentManager,
            ConsMileageDialogFragment.TAG
        )
    }

    companion object {

        fun newInstance() = ConsMileageFragment()
    }
}