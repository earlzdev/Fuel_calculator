package com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsMixedMileageBinding

class MixedMileageStatsFragment: BaseFragment<FragmentStatsMixedMileageBinding, MixedMileageStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsMixedMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = MixedMileageStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.valueList.observe(viewLifecycleOwner) {
            Log.d("tag", "onViewCreated: $it")
        }

    }

    companion object {

        fun newInstance() = MixedMileageStatsFragment()
    }
}