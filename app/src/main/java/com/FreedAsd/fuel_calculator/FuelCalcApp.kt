package com.FreedAsd.fuel_calculator

import android.app.Application
import com.FreedAsd.fuel_calculator.core.ViewModelsFactory
import com.FreedAsd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.FreedAsd.fuel_calculator.data.distance.DistanceInputData
import com.FreedAsd.fuel_calculator.data.distance.DistanceResultData
import com.FreedAsd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.FreedAsd.fuel_calculator.data.tripPrice.CalcTripPriceRepositoryImpl
import com.FreedAsd.fuel_calculator.domain.distance.DistanceInputDomain
import com.FreedAsd.fuel_calculator.domain.distance.DistanceResultDomain
import com.FreedAsd.fuel_calculator.domain.distance.interactor.Interactor
import com.FreedAsd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.FreedAsd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.FreedAsd.fuel_calculator.domain.distance.mappers.ResultDomainToUiMapper
import com.FreedAsd.fuel_calculator.domain.tripPrice.domainPriceMappers.InputDataDomainMapper
import com.FreedAsd.fuel_calculator.domain.tripPrice.domainPriceMappers.PriceResultDomainMapper
import com.FreedAsd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceInputUi
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceResultUi
import com.FreedAsd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper

class FuelCalcApp: Application() {

    // trip price
    private lateinit var calcPriceUseCase: CalcTripPriceUseCase
    private lateinit var inputUiMapper: PriceInputUiMapper
    private lateinit var resultUIMapper: PriceResultUiMapper
    private lateinit var priceRepository: CalcTripPriceRepositoryImpl
    private lateinit var inputDomainMapper: InputDataDomainMapper
    private lateinit var resultDomainMapper: PriceResultDomainMapper

    // distance
    private lateinit var distanceRepository: CalcMaxDistanceRepositoryImpl
    private lateinit var distanceMapper: DistanceInputData.MaxDistanceMapper
    private lateinit var priceMapper: DistanceInputData.TripPriceMapper

    private lateinit var interactor: Interactor
    private lateinit var distanceInputDomainMapper: BaseInputDomainToDataMapper
    private lateinit var distanceResultDomainMapper: BaseResultDataToDomainMapper

    //viewModelsFactory
    private lateinit var inputDistanceMapper: BaseInputUiToDomainMapper
    private lateinit var resultDistanceMapper: BaseResultDomainToUiMapper


    override fun onCreate() {
        super.onCreate()
        //trip price
        priceRepository = CalcTripPriceRepositoryImpl()
        inputDomainMapper = InputDataDomainMapper.Base()
        resultDomainMapper = PriceResultDomainMapper.Base()
        calcPriceUseCase = CalcTripPriceUseCase(priceRepository, inputDomainMapper, resultDomainMapper)
        inputUiMapper = PriceInputUiMapper.Base()
        resultUIMapper = PriceResultUiMapper.Base()

        // distance
        priceMapper = DistanceInputData.TripPriceMapper.Base()
        distanceMapper = DistanceInputData.MaxDistanceMapper.Base()
        distanceRepository = CalcMaxDistanceRepositoryImpl(distanceMapper, priceMapper)

        distanceInputDomainMapper = BaseInputDomainToDataMapper()
        distanceResultDomainMapper = BaseResultDataToDomainMapper()
        interactor = Interactor.Base(distanceRepository, distanceInputDomainMapper, distanceResultDomainMapper)

        //factory
        resultDistanceMapper = BaseResultDomainToUiMapper()
        inputDistanceMapper = BaseInputUiToDomainMapper()
    }

    val factory by lazy {
        ViewModelsFactory(calcPriceUseCase, inputUiMapper, resultUIMapper, interactor, inputDistanceMapper, resultDistanceMapper)
    }
}