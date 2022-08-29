package com.freed_asd.fuel_calculator.sl.price

import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.price.mappers.BasePriceResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.price.screens.PriceFragmentViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class PriceMainModule(private val core: PriceCoreModule) : BaseModule<PriceFragmentViewModel> {

    override fun viewModel(): PriceFragmentViewModel {
        val interactor = core.interactor
        val inputMapper = BasePriceInputUiToDomainMapper()
        val resultMapper = BasePriceResultDomainToUiMapper()
        return PriceFragmentViewModel(interactor, inputMapper, resultMapper)
    }
}