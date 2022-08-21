package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsCityMileageBinding
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class CityMileageStatsFragment : BaseFragment<FragmentStatsCityMileageBinding, CityMileageStatsViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsCityMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = CityMileageStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.valueList.observe(viewLifecycleOwner) {
            val lineDataSet = LineDataSet(consValues(it), "First")
            lineDataSet.circleRadius = 10f
            lineDataSet.setDrawFilled(true)
            lineDataSet.fillColor = resources.getColor(R.color.green)
            lineDataSet.valueTextSize = 18f

            val data = LineData(mileageValues(it), lineDataSet(it))
            binding.lineChart.data = data
            binding.lineChart.animateXY(2000, 2000)
        }
    }

    private fun mileageValues(value: List<ConsCityDbItemUi>) : List<String> {
        return value.map { it.mileage().toString() }
    }

    private fun consValues(value: List<ConsCityDbItemUi>) : ArrayList<Entry> {

        val size = value.size
        val entryList = arrayListOf<Entry>()

        val sizeList = mutableListOf<Int>()
        val consList = value.map { it.cons() }.toMutableList()

        for (i in 0 until size) {
            sizeList.add(i, i)
        }

        val combinedList: MutableMap<Int, Float> = mutableMapOf()

        for (i in sizeList) {
            combinedList[i] = consList[i]
        }

        for (i in sizeList) {
            entryList.add(Entry(combinedList.getValue(i), i))
        }
        return entryList
    }


    private fun lineDataSet(value: List<ConsCityDbItemUi>) : LineDataSet {
        val lineDataSet = LineDataSet(consValues(value), "first")
        lineDataSet.circleRadius = 10f
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = resources.getColor(R.color.green)
        lineDataSet.valueTextSize = 18f
        return lineDataSet
    }

    companion object {

        fun newInstance() = CityMileageStatsFragment()
    }
}