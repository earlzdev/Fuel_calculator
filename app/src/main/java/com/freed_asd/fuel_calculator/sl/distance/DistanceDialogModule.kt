package com.freed_asd.fuel_calculator.sl.distance

import com.freed_asd.fuel_calculator.presentation.distance.screens.dialog.DialogFragmentViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class DistanceDialogModule(private val core: DistanceCoreModule) : BaseModule<DialogFragmentViewModel> {

    override fun viewModel() = DialogFragmentViewModel()
}