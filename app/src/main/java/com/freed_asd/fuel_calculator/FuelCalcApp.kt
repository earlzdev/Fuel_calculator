package com.freed_asd.fuel_calculator

import android.app.Application
import com.freed_asd.fuel_calculator.core.ViewModelsFactory
import com.freed_asd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.tripPrice.CalcTripPriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.mappers.BasePriceResultDomainToUiMapper

class FuelCalcApp: Application() {

    // trip price
    private lateinit var priceInteractor: PriceInteractor
    private lateinit var inputUiMapper: BasePriceInputUiToDomainMapper
    private lateinit var resultUIMapper: BasePriceResultDomainToUiMapper
    private lateinit var priceRepository: CalcTripPriceRepositoryImpl
    private lateinit var inputDomainMapper: BasePriceInputDomainToDataMapper
    private lateinit var resultDomainMapper: BasePriceResultDataToDomainMapper

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
        inputDomainMapper = BasePriceInputDomainToDataMapper()
        resultDomainMapper = BasePriceResultDataToDomainMapper()
        inputUiMapper = BasePriceInputUiToDomainMapper()
        resultUIMapper = BasePriceResultDomainToUiMapper()
        priceInteractor = PriceInteractor.Base(priceRepository, inputDomainMapper, resultDomainMapper)

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
            priceInteractor,
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