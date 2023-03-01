package com.freed_asd.fuel_calculator.sl.price

import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceDbItemUiMapper
import com.freed_asd.fuel_calculator.presentation.price.screens.dialog.ResultViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class PriceResultModule(private val core: PriceCoreModule) : BaseModule<ResultViewModel> {

    override fun viewModel(): ResultViewModel {
        val interactor = core.interactor
        val priceDbUiToDomainMapper = BasePriceDbItemUiMapper()
        return ResultViewModel(interactor, priceDbUiToDomainMapper)
    }
}