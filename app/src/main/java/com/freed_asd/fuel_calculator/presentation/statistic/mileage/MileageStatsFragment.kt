package com.freed_asd.fuel_calculator.presentation.statistic.mileage

import android.view.LayoutInflater
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsMileageBinding

class MileageStatsFragment: BaseFragment<FragmentStatsMileageBinding, MileageStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = MileageStatsViewModel::class.java

    companion object {

        fun newInstance() = MileageStatsFragment()
    }
}