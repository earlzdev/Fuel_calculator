package com.freed_asd.fuel_calculator.sl.consumption

import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.MileageDialogViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class ConsMileageResultModule(private val core: ConsCoreModule) : BaseModule<MileageDialogViewModel> {

    override fun viewModel() = MileageDialogViewModel()

}