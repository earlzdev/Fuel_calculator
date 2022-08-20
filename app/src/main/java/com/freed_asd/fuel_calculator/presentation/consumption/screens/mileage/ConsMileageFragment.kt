package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsMileageBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.ConsMileageDialogFragment
import kotlinx.coroutines.launch

class ConsMileageFragment : BaseFragment<FragmentBaseConsMileageBinding, ConsMileageViewModel>() {

    private lateinit var pref: SharedPreferences
    private var previousMileage: Float = 0f
    private var shouldSave: Boolean = false

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsMileageViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        init()

        showPrevMileage()
        checkSavePrevMileageListener()

        viewModel.observe(viewLifecycleOwner, ::openResultDialog)
    }

    private fun calculate(validation: ConsMileageValidation.Base) {
        if (validation.validate()) {
            viewModel.calculate(ConsInputUi.Base(
                binding.etCurrentMileage.text.toString().toFloat() - binding.etPreviousMileage.text.toString().toFloat(),
                binding.etFilledFuel.text.toString().toFloat()
            ))
            savePrevMileage()
        }
    }

    private fun openResultDialog(resultEvent: Event<ConsResultUi>) {
        val result = resultEvent.value ?: return
        ConsMileageDialogFragment.newInstance(result).show(
            parentFragmentManager,
            ConsMileageDialogFragment.TAG
        )
    }

    private fun savePrevMileage() {
        shouldSave = pref.getBoolean(SAVE_PREV_MILEAGE_CHECK, false)
        Log.d("tag", "savePrevMileage: checkSave - $shouldSave")
        if (shouldSave) {

            previousMileage = binding.etCurrentMileage.text.toString().toFloat()
            binding.etPreviousMileage.setText(previousMileage.toString())
            pref.edit()?.putFloat(PREVIOUS_MILEAGE, previousMileage)?.apply()
        }
    }

    private fun showPrevMileage() {

        val check = pref.getBoolean(SAVE_PREV_MILEAGE_CHECK, false)
        val prevMileage = pref.getFloat(PREVIOUS_MILEAGE, 0f)
        if (check) {
            binding.checkSavePrevMileage.isChecked = true
            binding.etPreviousMileage.isEnabled = false
            binding.etPreviousMileage.setText(prevMileage.toString())
            binding.tvPreviousMileage.isEnabled = false
        } else {
            binding.checkSavePrevMileage.isChecked = false
            binding.etPreviousMileage.isEnabled = true
            binding.tvPreviousMileage.isEnabled = true
        }
    }

    private fun checkSavePrevMileageListener() {
        binding.checkSavePrevMileage.setOnCheckedChangeListener { _, _ ->
            if (binding.etPreviousMileage.text.isEmpty()) {
                binding.checkSavePrevMileage.isChecked = false
                binding.etPreviousMileage.error = context?.getString(R.string.empty_error_msg)
            } else if (!binding.checkSavePrevMileage.isChecked) {
                binding.etPreviousMileage.isEnabled = true
                binding.tvPreviousMileage.isEnabled = true
                pref.edit().putBoolean(SAVE_PREV_MILEAGE_CHECK, false).apply()
            } else {
                binding.etPreviousMileage.isEnabled = false
                binding.tvPreviousMileage.isEnabled = false
                pref.edit().putBoolean(SAVE_PREV_MILEAGE_CHECK, true).apply()
                val prevMileage = binding.etPreviousMileage.text.toString().toFloat()
                pref.edit().putFloat(PREVIOUS_MILEAGE, prevMileage).apply()
            }
        }
    }

    private fun init() {
        val spinner = binding.statsSpinner

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val validation = ConsMileageValidation.Base(
                    binding.etCurrentMileage,
                    binding.etPreviousMileage,
                    binding.etFilledFuel
                )
                binding.calcButton.setOnClickListener { calculate(validation)

                    when (parent?.getItemAtPosition(position).toString()) {
                        DO_NOT_ADD -> {
                            return@setOnClickListener
                        }
                        MIXED_REGIME -> {
                            viewModel.setIntoStats(
                                MIXED_REGIME,
                                binding.etCurrentMileage.text.toString().toFloat()
                            )
                        }
                        CITY_REGIME -> {
                            viewModel.setIntoStats(
                                CITY_REGIME,
                                binding.etCurrentMileage.text.toString().toFloat()
                            )
                        }
                        TRACK_REGIME -> {
                            viewModel.setIntoStats(
                                TRACK_REGIME,
                                binding.etCurrentMileage.text.toString().toFloat()
                            )
                        }
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.stats_spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    companion object {

        const val DO_NOT_ADD = "Не добавлять"
        const val MIXED_REGIME = "Смешанный режим езды"
        const val CITY_REGIME = "Городской режим езды"
        const val TRACK_REGIME = "Трассовый режим езды"
        const val PREVIOUS_MILEAGE = "PREVIOUS MILEAGE"
        const val SAVE_PREV_MILEAGE_CHECK = "SAVE_PREV_MILEAGE_CHECK"

        fun newInstance() = ConsMileageFragment()
    }
}