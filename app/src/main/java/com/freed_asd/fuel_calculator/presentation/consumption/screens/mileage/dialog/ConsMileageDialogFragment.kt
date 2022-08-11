package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.FragmentDialogConsumptionMileageBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi

class ConsMileageDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogConsumptionMileageBinding? = null
    private val binding: FragmentDialogConsumptionMileageBinding get() = _binding!!

    private lateinit var viewModel: MileageDialogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as FuelCalcApp).factory
        viewModel = ViewModelProvider(this, factory)[MileageDialogViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogConsumptionMileageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.provideResult(onDetails())
        viewModel.observe(viewLifecycleOwner){
            binding.maxDistanceEd.text = getString(R.string.cons_litersOnKm, String.format("%.2f", it.consumption()))
        }
    }

    private fun onDetails() = requireArguments().getParcelable<ConsResultUi.Base>(RESULT_KEY)
        ?: throw IllegalStateException("calculation result can not be null")

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {

        const val TAG = "ConsumptionDialogFragment"
        const val RESULT_KEY = "RESULT_KEY"

        fun newInstance(result: ConsResultUi) = ConsMileageDialogFragment().apply {
            arguments = bundleOf(RESULT_KEY to result)
        }
    }
}