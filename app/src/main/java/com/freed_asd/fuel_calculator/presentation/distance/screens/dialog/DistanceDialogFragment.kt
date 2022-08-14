package com.freed_asd.fuel_calculator.presentation.distance.screens.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.FragmentDialogDistanceBinding
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi

class DistanceDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogDistanceBinding? = null
    private val binding: FragmentDialogDistanceBinding get() = _binding!!

    private lateinit var viewModel: DialogFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as FuelCalcApp).factory
        viewModel = ViewModelProvider(this, factory)[DialogFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogDistanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.provideResult(details())
        viewModel.observe(viewLifecycleOwner) {
            binding.maxDistanceEd.text = getString(
                R.string.kilometers,
                String.format("%.2f", it.distance()
                ))
            binding.distancePriceEd.text = getString(
                R.string.rubles,
                String.format("%.2f", it.price()
                ))
        }
        binding.saveBtnDistance.setOnClickListener {
            binding.tvAddName.isVisible = true
            binding.saveName.isVisible = true
            binding.distanceSaveBtn.isVisible = true
            binding.distanceSaveBtn.setOnClickListener {
                viewModel.insertIntoDb(binding.saveName.text.toString())
                binding.isSavedDistance.isVisible = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun details() = requireArguments().getParcelable<DistanceResultUi.Base>(RESULT_KEY)
        ?: throw IllegalStateException("calculation result can not be null")

    override fun onStart() {
        super.onStart()
        val width = resources.displayMetrics.widthPixels * 0.85
        dialog?.window?.setLayout(width.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    companion object {

        const val TAG = "DistanceDialogFragment"
        const val RESULT_KEY = "RESULT_KEY"

        fun newInstance(result: DistanceResultUi) = DistanceDialogFragment().apply {
            arguments = bundleOf(RESULT_KEY to result)
        }
    }
}