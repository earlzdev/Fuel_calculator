package com.freed_asd.fuel_calculator.presentation.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.freed_asd.fuel_calculator.databinding.FragmentDialogAboutBinding
import com.freed_asd.fuel_calculator.presentation.price.screens.dialog.ResultDialogFragment

class AboutDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogAboutBinding? = null
    private val binding: FragmentDialogAboutBinding get() = _binding!!

    override fun onStart() {
        super.onStart()
        isCancelable = true
        val width = resources.displayMetrics.widthPixels * ResultDialogFragment.DEFAULT_COEFF
        dialog?.window?.setLayout(width.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        const val TAG = "AboutDialogFragment"

        fun newInstance() = AboutDialogFragment()
    }
}