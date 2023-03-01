package com.freed_asd.fuel_calculator.presentation.statistic.mileage.track

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.presentation.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsTrackMileageBinding
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class TrackMileageStatsFragment : BaseFragment<FragmentStatsTrackMileageBinding, TrackMileageStartViewModel>() {

    private val parentList: MutableMap<Int, Long> = mutableMapOf()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsTrackMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = TrackMileageStartViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.valueList.observe(viewLifecycleOwner) {

            if (it.isEmpty()) {
                binding.noData.isVisible = true
                binding.mileage.isVisible = false
                binding.cons.isVisible = false
                binding.entryDetailsTv.isVisible = false
                binding.lineChart.isVisible = false
                binding.deleteBtn.isVisible = false
            } else {
                binding.noData.isVisible = false
                binding.mileage.isVisible = true
                binding.cons.isVisible = true
                binding.entryDetailsTv.isVisible = true
                binding.lineChart.isVisible = true
                binding.deleteBtn.isVisible = true

                val lineData = lineDataSet(it)

                val data = LineData(mileageValues(it), lineData)
                binding.lineChart.data = data

                with(binding.lineChart) {

                    animateXY(2000, 2000)
                    axisRight.setDrawGridLines(false)
                    axisLeft.setDrawGridLines(false)
                    setVisibleXRangeMaximum(7f)
                    moveViewToX(7f)

                    binding.lineChart.setOnChartValueSelectedListener(object :
                        OnChartValueSelectedListener {
                        override fun onValueSelected(e: Entry?, dataSetIndex: Int, h: Highlight?) {
                            binding.mileage.isEnabled = true
                            binding.cons.isEnabled = true
                            val index = lineData.getEntryIndex(e)
                            val cons = lineData.getYValForXIndex(index)
                            val mileage = binding.lineChart.getXValue(index)
                            binding.mileage.text = getString(R.string.mileage_stats, String.format("%s", mileage))
                            binding.cons.text = getString(R.string.cons_stats, String.format("%.2f", cons))

                            binding.deleteBtn.setOnClickListener {

                                alertDialog(requireContext(), e!!)
                            }
                        }

                        override fun onNothingSelected() {}
                    })
                }
            }
        }
    }

    private fun alertDialog(context: Context, e: Entry): AlertDialog {
        val builder = AlertDialog.Builder(context)
            .setCancelable(true)
            .setMessage(
            """Удалить вершину графика со следующими данными: 
    ${binding.mileage.text} 
    ${binding.cons.text} ?"""
        )
            .setTitle(getString(R.string.accept_removing))
            .setPositiveButton(getString(R.string.remove)) { dialog, wich ->
                viewModel.removeValue(initRemovedEntry(e.xIndex)!!)
            }
            .setNegativeButton(getString(R.string.dont_remove)) { dialog, wich ->
                Toast.makeText(context, getString(R.string.stoped_removing), Toast.LENGTH_SHORT).show()
            }
            .show()
        return builder
    }

    private fun initRemovedEntry(eIndex: Int) = parentList[eIndex]

    private fun mileageValues(value: List<ConsTrackDbItemUi>) : List<String> {
        return value.map { it.mileage().toString() }
    }

    private fun consValues(value: List<ConsTrackDbItemUi>) : ArrayList<Entry> {

        val size = value.size
        val entryList = arrayListOf<Entry>()

        val sizeList = mutableListOf<Int>()
        val consList = value.map { it.cons() }.toMutableList()
        val valuesIdList = value.map { it.id() }.toMutableList()

        for (i in 0 until size) {
            sizeList.add(i, i)
        }

        val combinedList: MutableMap<Int, Float> = mutableMapOf()

        for (i in sizeList) {
            combinedList[i] = consList[i]
        }

        for (i in sizeList) {
            parentList[i] = valuesIdList[i]
        }

        for (i in sizeList) {
            entryList.add(Entry(combinedList.getValue(i), i))
        }
        return entryList
    }


    private fun lineDataSet(value: List<ConsTrackDbItemUi>) : LineDataSet {
        val lineDataSet = LineDataSet(consValues(value), getString(R.string.track_drive_regime))
        lineDataSet.circleRadius = 10f
        lineDataSet.setDrawFilled(true)
        lineDataSet.valueTextSize = 18f
        lineDataSet.fillAlpha = 30
        lineDataSet.isHighlightEnabled = true
        lineDataSet.setDrawHighlightIndicators(true)
        return lineDataSet
    }


    companion object {

        fun newInstance() = TrackMileageStatsFragment()
    }
}