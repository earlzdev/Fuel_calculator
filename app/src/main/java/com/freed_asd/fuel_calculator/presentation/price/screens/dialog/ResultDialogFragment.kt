package com.freed_asd.fuel_calculator.presentation.price.screens.dialog

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.FuelCalcApp
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.databinding.FragmentDialogPriceBinding
import com.freed_asd.fuel_calculator.presentation.price.PriceResultUi

class ResultDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogPriceBinding? = null
    private val binding: FragmentDialogPriceBinding get() = _binding!!

    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = (requireActivity().application as FuelCalcApp).factory
        viewModel = ViewModelProvider(this, factory)[ResultViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogPriceBinding.inflate(inflater, container, false)

        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.provideResult(onDetails())
        isPassengerAlone()
        viewModel.observe(viewLifecycleOwner){
            binding.liters.text = getString(
                R.string.fuel_need_example,
                String.format("%.2f", it.needFuel())
            )
            binding.tvKilometers.text = getString(
                R.string.distance_example,
                it.distance().toInt()
            )
            binding.generalPriceEd.text = getString(
                R.string.general_price_example,
                String.format("%.2f", it.generalPrice())
            )
            binding.tvValuePriceForEveryone.text = getString(
                R.string.by_person_example,
                String.format("%.2f", it.everyonePrice())
            )
        }

// 10.1.32.210

        binding.saveBtnPrice.setOnClickListener {

            viewModel.insertIntoDb(onDetails().distance().toString())
            binding.isSavedPrice.isVisible = true

//            binding.tvAddName.isVisible = true
//            binding.saveNameEd.isVisible = true
//            binding.priceSaveBtn.isVisible = true
//            binding.priceSaveBtn.setOnClickListener {
//                viewModel.insertIntoDb(binding.saveNameEd.text.toString())
//                binding.isSavedPrice.isVisible = true
//            }
        }
    }

    private fun onDetails() = requireArguments().getParcelable<PriceResultUi.Base>(RESULT_DETAILS)
        ?: throw  IllegalStateException("calculation result cannot be null")

    private fun isPassengerAlone() {
        if (onDetails().passengers() == 1f) {
            binding.tvValuePriceForEveryone.isVisible = false
            binding.tvForEveryoneTripPrice.isVisible = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        val width = resources.displayMetrics.widthPixels * 0.85
        dialog?.window?.setLayout(width.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    companion object {

        const val TAG = "RESULT_FRAGMENT_TAG"
        const val RESULT_DETAILS = "RESULT_DETAILS"

        fun newInstance(result: PriceResultUi) = ResultDialogFragment().apply {
            arguments = bundleOf(RESULT_DETAILS to result)
        }
    }
}