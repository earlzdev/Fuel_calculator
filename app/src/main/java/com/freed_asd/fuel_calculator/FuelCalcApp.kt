package com.freed_asd.fuel_calculator

import android.app.Application
import com.freed_asd.fuel_calculator.core.ViewModelsFactory
import com.freed_asd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.price.BasePriceItemDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.CalcTripPriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbToDataItemMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemUiMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.price.mappers.BasePriceResultDomainToUiMapper

class FuelCalcApp: Application() {

    // trip price
    private lateinit var priceInteractor: PriceInteractor
    private lateinit var inputUiMapper: BasePriceInputUiToDomainMapper
    private lateinit var resultUIMapper: BasePriceResultDomainToUiMapper
    private lateinit var priceRepository: CalcTripPriceRepositoryImpl
    private lateinit var inputDomainMapper: BasePriceInputDomainToDataMapper
    private lateinit var resultDomainMapper: BasePriceResultDataToDomainMapper

    private lateinit var priceDbDomainToDataMapper: BasePriceDbITemDomainMapper
    private lateinit var priceDbDataToDbMapper: BasePriceItemDbMapper
    private lateinit var priceDbUiMapper: BasePriceDbItemUiMapper

    private lateinit var priceDataToDomainMapper: BasePriceDbItemDataToDomainMapper
    private lateinit var priceDbItemToDataMapper: BasePriceDbToDataItemMapper

    // distance
    private lateinit var distanceRepository: CalcMaxDistanceRepositoryImpl
    private lateinit var distanceMapper: DistanceInputData.MaxDistanceMapper
    private lateinit var priceMapper: DistanceInputData.TripPriceMapper

    private lateinit var distanceInteractor: DistanceInteractor
    private lateinit var distanceInputDomainMapper: BaseInputDomainToDataMapper
    private lateinit var distanceResultDomainMapper: BaseResultDataToDomainMapper

    //consumption
    private lateinit var appDataBase: AppDataBase
    private lateinit var consRepository: ConsumptionRepository
    private lateinit var inputConsInteractorMapper: BaseConsInputDomainToDataMapper
    private lateinit var resultConsInteractorMapper: BaseConsResultDataToDomainMapper

    private lateinit var consInteractor: ConsInteractor
    private lateinit var inputConsMapper: BaseConsInputUiToDomainMapper
    private lateinit var resultConsMapper: BaseConsResultDomainToUiMapper

    //viewModelsFactory
    private lateinit var inputDistanceMapper: BaseInputUiToDomainMapper
    private lateinit var resultDistanceMapper: BaseResultDomainToUiMapper
    private lateinit var priceDbDomainMapper: BasePriceDbItemDomainMapperUi

    override fun onCreate() {
        super.onCreate()
        appDataBase = AppDataBase.localDataBase(this)

        //trip price
        priceDbItemToDataMapper = BasePriceDbToDataItemMapper()
        priceDbUiMapper = BasePriceDbItemUiMapper()
        priceDbDataToDbMapper = BasePriceItemDbMapper()
        priceRepository = CalcTripPriceRepositoryImpl(appDataBase, priceDbDataToDbMapper, priceDbItemToDataMapper)
        inputDomainMapper = BasePriceInputDomainToDataMapper()
        resultDomainMapper = BasePriceResultDataToDomainMapper()
        inputUiMapper = BasePriceInputUiToDomainMapper()
        resultUIMapper = BasePriceResultDomainToUiMapper()
        priceDbDomainToDataMapper = BasePriceDbITemDomainMapper()
        priceDataToDomainMapper = BasePriceDbItemDataToDomainMapper()
        priceInteractor = PriceInteractor.Base(priceRepository, inputDomainMapper, resultDomainMapper, priceDbDomainToDataMapper, priceDataToDomainMapper)

        // distance
        priceMapper = DistanceInputData.TripPriceMapper.Base()
        distanceMapper = DistanceInputData.MaxDistanceMapper.Base()
        distanceRepository = CalcMaxDistanceRepositoryImpl(distanceMapper, priceMapper)

        distanceInputDomainMapper = BaseInputDomainToDataMapper()
        distanceResultDomainMapper = BaseResultDataToDomainMapper()
        distanceInteractor = DistanceInteractor.Base(distanceRepository, distanceInputDomainMapper, distanceResultDomainMapper)

        //consumption
        consRepository = ConsumptionRepositoryImpl(appDataBase)
        inputConsInteractorMapper = BaseConsInputDomainToDataMapper()
        resultConsInteractorMapper = BaseConsResultDataToDomainMapper()
        consInteractor = ConsInteractor.Base(consRepository, inputConsInteractorMapper, resultConsInteractorMapper)

        inputConsMapper = BaseConsInputUiToDomainMapper()
        resultConsMapper = BaseConsResultDomainToUiMapper()

        //factory
        resultDistanceMapper = BaseResultDomainToUiMapper()
        inputDistanceMapper = BaseInputUiToDomainMapper()

        priceDbDomainMapper = BasePriceDbItemDomainMapperUi()
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
            resultConsMapper,
            priceDbUiMapper,
            priceDbDomainMapper,
        )
    }
}