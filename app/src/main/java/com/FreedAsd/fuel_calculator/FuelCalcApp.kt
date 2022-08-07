package com.freedasd.fuel_calculator

import android.app.Application
import com.freedasd.fuel_calculator.core.ViewModelsFactory
import com.freedasd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freedasd.fuel_calculator.data.distance.DistanceInputData
import com.freedasd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freedasd.fuel_calculator.data.tripPrice.CalcTripPriceRepositoryImpl
import com.freedasd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freedasd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freedasd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.freedasd.fuel_calculator.domain.tripPrice.domainPriceMappers.InputDataDomainMapper
import com.freedasd.fuel_calculator.domain.tripPrice.domainPriceMappers.PriceResultDomainMapper
import com.freedasd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.freedasd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freedasd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.freedasd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper
import com.freedasd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freedasd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freedasd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freedasd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freedasd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freedasd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freedasd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper

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

    private lateinit var distanceInteractor: DistanceInteractor
    private lateinit var distanceInputDomainMapper: BaseInputDomainToDataMapper
    private lateinit var distanceResultDomainMapper: BaseResultDataToDomainMapper


    //consumption
    private lateinit var consRepository: ConsumptionRepository
    private lateinit var inputConsInteractorMapper: BaseConsInputDomainToDataMapper
    private lateinit var resultConsInteractorMapper: BaseConsResultDataToDomainMapper

    private lateinit var consInteractor: ConsInteractor
    private lateinit var inputConsMapper: BaseConsInputUiToDomainMapper
    private lateinit var resultConsMapper: BaseConsResultDomainToUiMapper

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
        distanceInteractor = DistanceInteractor.Base(distanceRepository, distanceInputDomainMapper, distanceResultDomainMapper)

        //consumption
        consRepository = ConsumptionRepositoryImpl()
        inputConsInteractorMapper = BaseConsInputDomainToDataMapper()
        resultConsInteractorMapper = BaseConsResultDataToDomainMapper()
        consInteractor = ConsInteractor.Base(consRepository, inputConsInteractorMapper, resultConsInteractorMapper)

        inputConsMapper = BaseConsInputUiToDomainMapper()
        resultConsMapper = BaseConsResultDomainToUiMapper()

        //factory
        resultDistanceMapper = BaseResultDomainToUiMapper()
        inputDistanceMapper = BaseInputUiToDomainMapper()
    }

    val factory by lazy {
        ViewModelsFactory(
            calcPriceUseCase,
            inputUiMapper,
            resultUIMapper,
            distanceInteractor,
            inputDistanceMapper,
            resultDistanceMapper,
            consInteractor,
            inputConsMapper,
            resultConsMapper
        )
    }
}