package com.freed_asd.fuel_calculator.presentation.statistic.mileage.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTrackMileageBinding
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class TrackMileageStatsFragment : BaseFragment<FragmentStatsTrackMileageBinding, TrackMileageStartViewModel>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTrackMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = TrackMileageStartViewModel::class.java

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

    private fun mileageValues(value: List<ConsTrackDbItemUi>) : List<String> {
        return value.map { it.mileage().toString() }
    }

    private fun consValues(value: List<ConsTrackDbItemUi>) : ArrayList<Entry> {

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


    private fun lineDataSet(value: List<ConsTrackDbItemUi>) : LineDataSet {
        val lineDataSet = LineDataSet(consValues(value), "first")
        lineDataSet.circleRadius = 10f
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = resources.getColor(R.color.green)
        lineDataSet.valueTextSize = 18f
        return lineDataSet
    }


    companion object {

        fun newInstance() = TrackMileageStatsFragment()
    }
}