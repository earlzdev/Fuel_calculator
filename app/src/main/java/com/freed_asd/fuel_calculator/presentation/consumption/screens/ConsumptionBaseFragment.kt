package com.freed_asd.fuel_calculator.presentation.consumption.screens

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.presentation.core.BaseFragment
import com.freed_asd.fuel_calculator.databinding.FragmentBaseConsumptionBinding
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.ConsDistanceFragment
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.ConsMileageFragment

class ConsumptionBaseFragment : BaseFragment<FragmentBaseConsumptionBinding, ConsFragViewModel>(), AdapterView.OnItemSelectedListener {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBaseConsumptionBinding.inflate(inflater, container, false)

    override fun viewModelClass() = ConsFragViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner()
    }

    private fun initSpinner() {

        val calcSpinner = binding.spinnerCalc
        calcSpinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.calc_consumption_of,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            calcSpinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

//        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
//        val firstStart = sharedPref.getBoolean(FIRST_START, true)

        when(parent?.getItemAtPosition(position).toString()) {
            CALC_BY_MILEAGE -> {

                    loadFragment(ConsMileageFragment.newInstance())

//                if (requireActivity().supportFragmentManager.findFragmentByTag(ConsMileageFragment.TAG) == null) {
//                    loadFragment(ConsMileageFragment.newInstance())
//                }

            }
            CALC_BY_DISTANCE -> {
                loadFragment(ConsDistanceFragment.newInstance())
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

    companion object {

        private const val FIRST_START = "FIRST START"
        private const val CALC_BY_MILEAGE = "Показаниям пробега"
        private const val CALC_BY_DISTANCE = "Пройденному расстоянию"

        fun newInstance() = ConsumptionBaseFragment()
    }
}