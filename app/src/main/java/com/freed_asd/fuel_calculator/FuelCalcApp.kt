package com.freed_asd.fuel_calculator

import android.app.Application
import com.freed_asd.fuel_calculator.core.ViewModelsFactory
import com.freed_asd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.price.BasePriceItemDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.PriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbToDataItemMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDomainToUiMapper
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
    private lateinit var priceRepository: PriceRepositoryImpl
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

    private lateinit var mixedDataToDomainMapper: ConsMixedDataToDomainMapper.Base
    private lateinit var consMixedDbToDataMapper: ConsMixedDbToDataMapper.Base
    private lateinit var cityDataToDomainMapper: ConsCityDataToDomainMapper.Base
    private lateinit var cityDbToDataMapper: ConsCityDbToDataMapper.Base
    private lateinit var trackDbToDataMapper: ConsTrackDbToDataMapper.Base
    private lateinit var trackDataToDomainMapper: ConsTrackDataToDomainMapper.Base

    //viewModelsFactory
    private lateinit var inputDistanceMapper: BaseInputUiToDomainMapper
    private lateinit var resultDistanceMapper: BaseResultDomainToUiMapper
    private lateinit var priceDbDomainMapper: BasePriceDbItemDomainMapperUi
    private lateinit var consMixedDomainToUiMapper : ConsMixedDomainToUiMapper.Base
    private lateinit var cityDomainToUiMapper: ConsCityDomainToUiMapper.Base
    private lateinit var trackDomainToUiMapper: ConsTrackDomainToUiMapper.Base


    override fun onCreate() {
        super.onCreate()
        appDataBase = AppDataBase.localDataBase(this)

        //trip price
        priceDbItemToDataMapper = BasePriceDbToDataItemMapper()
        priceDbUiMapper = BasePriceDbItemUiMapper()
        priceDbDataToDbMapper = BasePriceItemDbMapper()
        priceRepository = PriceRepositoryImpl(appDataBase, priceDbDataToDbMapper, priceDbItemToDataMapper)
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
        trackDbToDataMapper = ConsTrackDbToDataMapper.Base()
        trackDataToDomainMapper = ConsTrackDataToDomainMapper.Base()
        cityDbToDataMapper = ConsCityDbToDataMapper.Base()
        consMixedDbToDataMapper = ConsMixedDbToDataMapper.Base()
        consRepository = ConsumptionRepositoryImpl(appDataBase, consMixedDbToDataMapper, cityDbToDataMapper, trackDbToDataMapper)
        inputConsInteractorMapper = BaseConsInputDomainToDataMapper()
        resultConsInteractorMapper = BaseConsResultDataToDomainMapper()

        mixedDataToDomainMapper = ConsMixedDataToDomainMapper.Base()
        cityDataToDomainMapper = ConsCityDataToDomainMapper.Base()

        consInteractor = ConsInteractor.Base(consRepository, inputConsInteractorMapper, resultConsInteractorMapper, mixedDataToDomainMapper, cityDataToDomainMapper, trackDataToDomainMapper)

        inputConsMapper = BaseConsInputUiToDomainMapper()
        resultConsMapper = BaseConsResultDomainToUiMapper()

        //factory
        resultDistanceMapper = BaseResultDomainToUiMapper()
        inputDistanceMapper = BaseInputUiToDomainMapper()

        priceDbDomainMapper = BasePriceDbItemDomainMapperUi()
        consMixedDomainToUiMapper = ConsMixedDomainToUiMapper.Base()
        cityDomainToUiMapper = ConsCityDomainToUiMapper.Base()
        trackDomainToUiMapper = ConsTrackDomainToUiMapper.Base()
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
            consMixedDomainToUiMapper,
            cityDomainToUiMapper,
            trackDomainToUiMapper
        )
    }
}