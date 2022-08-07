package com.freedasd.fuel_calculator.presentation.consumption.screens.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.freedasd.fuel_calculator.FuelCalcApp
import com.freedasd.fuel_calculator.R
import com.freedasd.fuel_calculator.databinding.FragmentDialogConsumptionBinding
import com.freedasd.fuel_calculator.presentation.consumption.ConsResultUi

class ConsumptionDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogConsumptionBinding? = null
    private val binding: FragmentDialogConsumptionBinding get() = _binding!!

    private lateinit var viewModel: ConsDialogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as FuelCalcApp).factory
        viewModel = ViewModelProvider(this, factory)[ConsDialogViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogConsumptionBinding.inflate(inflater, container, false)
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

        fun newInstance(result: ConsResultUi) = ConsumptionDialogFragment().apply {
            arguments = bundleOf(RESULT_KEY to result)
        }
    }
}