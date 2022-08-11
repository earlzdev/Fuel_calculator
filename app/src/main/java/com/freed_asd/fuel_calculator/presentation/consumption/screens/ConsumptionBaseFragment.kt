package com.freed_asd.fuel_calculator.presentation.consumption.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseFragment
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

        val spinner = binding.spinner
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.calc_consumption_of,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(position).toString()
        when(selectedItem) {
            "Пробегу" -> {
                loadFragment(ConsMileageFragment.newInstance())
            }
            "Расстоянию" -> {
                loadFragment(ConsDistanceFragment.newInstance())
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

    companion object {

        fun newInstance() = ConsumptionBaseFragment()
    }
}