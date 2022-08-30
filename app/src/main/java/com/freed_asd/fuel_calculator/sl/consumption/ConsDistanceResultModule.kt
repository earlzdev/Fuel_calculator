package com.freed_asd.fuel_calculator.sl.consumption

import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog.DistanceDialogViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class ConsDistanceResultModule(private val core: ConsCoreModule) : BaseModule<DistanceDialogViewModel> {

    override fun viewModel() = DistanceDialogViewModel()
}