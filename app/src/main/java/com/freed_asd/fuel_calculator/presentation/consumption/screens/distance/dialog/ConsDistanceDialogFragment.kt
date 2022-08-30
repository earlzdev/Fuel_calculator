package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.FragmentDialogConsumptionDistanceBinding
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi

class ConsDistanceDialogFragment: DialogFragment() {

    private var _binding: FragmentDialogConsumptionDistanceBinding? = null
    private val binding: FragmentDialogConsumptionDistanceBinding get() = _binding!!

    private lateinit var viewModel: DistanceDialogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as FuelCalcApp).provide()
        viewModel = ViewModelProvider(this, factory)[DistanceDialogViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogConsumptionDistanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.provideResult(onDetails())
        viewModel.observe(viewLifecycleOwner) {
            binding.edMaxDistance.text = getString(R.string.cons_litersOnKm, String.format("%.2f", it.consumption()))
        }
    }

    private fun onDetails() = requireArguments().getParcelable<ConsResultUi.Base>(RESULT_KEY)
        ?: throw IllegalStateException("calculation result can not be null")

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        const val TAG = "ConsDistanceDialogFragment"
        const val RESULT_KEY = "RESULT_KEY"

        fun newInstance(result: ConsResultUi) = ConsDistanceDialogFragment().apply {
            arguments = bundleOf(RESULT_KEY to result)
        }
    }
}