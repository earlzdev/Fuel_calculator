package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentStatsCityMileageBinding
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class CityMileageStatsFragment : BaseFragment<FragmentStatsCityMileageBinding, CityMileageStatsViewModel>() {

    private val parentList: MutableMap<Int, Long> = mutableMapOf()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStatsCityMileageBinding.inflate(inflater, container, false)

    override fun viewModelClass() = CityMileageStatsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.valueList.observe(viewLifecycleOwner) {

            if (it.isEmpty()) {
                binding.noData.isVisible = true
                binding.testText.isVisible = false
                binding.textview.isVisible = false
                binding.lineChart.isVisible = false
                binding.deleteBtn.isVisible = false
            } else {
                binding.noData.isVisible = false
                binding.testText.isVisible = true
                binding.textview.isVisible = true
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
                        binding.textview.isEnabled = true
                        binding.testText.isEnabled = true
                        val index = lineData.getEntryIndex(e)
                        val cons = lineData.getYValForXIndex(index)
                        val mileage = binding.lineChart.getXValue(index)
                        binding.testText.text = cons.toString()
                        binding.textview.text = mileage.toString()

                        binding.deleteBtn.setOnClickListener {

                            alertDialog(requireContext(), e!!)
                        }
                    }

                    override fun onNothingSelected() {
                        binding.textview.isEnabled = false
                        binding.testText.isEnabled = false
                    }
                })
            }
            }
        }
    }

    private fun alertDialog(context: Context, e: Entry): AlertDialog {
        val builder = AlertDialog.Builder(context)
            .setCancelable(true)
            .setMessage("Da ili net?" + binding.testText.text.toString() + binding.textview.text.toString())
            .setTitle("Udalit?")
            .setPositiveButton("Da, Udalit") { dialog, wich ->
                viewModel.removeValue(initRemovedEntry(e.xIndex)!!)
            }
            .setNegativeButton("Ne, ne udalay") { dialog, wich ->
                Toast.makeText(context, "Ne udalyau )", Toast.LENGTH_SHORT).show()
            }
            .show()
        return builder
    }

    private fun initRemovedEntry(eIndex: Int) = parentList[eIndex]

    private fun mileageValues(value: List<ConsCityDbItemUi>) : ArrayList<String> {
        val mileageArrayList = arrayListOf<String>()
        for (i in value.indices) {
            mileageArrayList.add( value[i].mileage().toString() )
        }
        return mileageArrayList
    }

    private fun consValues(value: List<ConsCityDbItemUi>) : ArrayList<Entry> {

        val size = value.size
        val entryList = arrayListOf<Entry>()

        val sizeList = mutableListOf<Int>()
        val consList = value.map { it.cons() }.toMutableList()
        val combinedList: MutableMap<Int, Float> = mutableMapOf()
        val valuesIdList = value.map { it.id() }.toMutableList()

        for (i in 0 until size) {
            sizeList.add(i, i)
        }

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

    private fun lineDataSet(value: List<ConsCityDbItemUi>) : LineDataSet {
        val lineDataSet = LineDataSet(consValues(value), "Consumption Mixed drive regime")
        lineDataSet.circleRadius = 10f
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = resources.getColor(R.color.green)
        lineDataSet.valueTextSize = 18f
        lineDataSet.setDrawValues(false)
        lineDataSet.fillColor = resources.getColor(R.color.green)
        lineDataSet.fillAlpha = 30
        lineDataSet.isHighlightEnabled = true
        lineDataSet.setDrawHighlightIndicators(true)
        return lineDataSet
    }

    companion object {

        fun newInstance() = CityMileageStatsFragment()
    }
}