package com.FreedAsd.fuel_calculator

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.FreedAsd.fuel_calculator.core.ViewModelsFactory
import com.FreedAsd.fuel_calculator.data.calc_trip_price.CalcTripPriceRepositoryImpl
import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceInputData
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.CalcTripPriceRepository
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers.InputDataDomainMapper
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers.PriceResultDomainMapper
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceResultUiMapper

class FuelCalcApp: Application() {

    private lateinit var calcPriceUseCase: CalcTripPriceUseCase
    private lateinit var inputMapper: PriceInputUiMapper
    private lateinit var resultMapper: PriceResultUiMapper
    private lateinit var repository: CalcTripPriceRepositoryImpl
    private lateinit var inputDomainMapper: InputDataDomainMapper
    private lateinit var resultDomainMapper: PriceResultDomainMapper

    override fun onCreate() {
        super.onCreate()
        repository = CalcTripPriceRepositoryImpl()
        inputDomainMapper = InputDataDomainMapper.Base()
        resultDomainMapper = PriceResultDomainMapper.Base()
        calcPriceUseCase = CalcTripPriceUseCase(repository, inputDomainMapper, resultDomainMapper)
        inputMapper = PriceInputUiMapper.Base()
        resultMapper = PriceResultUiMapper.Base()
    }

    val factory by lazy {
        ViewModelsFactory(calcPriceUseCase, inputMapper, resultMapper)
    }
}