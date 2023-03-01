package com.freed_asd.fuel_calculator.sl.price

import android.content.Context
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.mappers.BaseSavedTripPriceDataToDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.PriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BaseSavedTripPriceDomainToDataMapper
import com.freed_asd.fuel_calculator.data.tripPrice.models.SavedTripPriceDbToDataMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.sl.ResourceProvider

class PriceCoreModule {

    lateinit var interactor: PriceInteractor
    lateinit var resourceProvider: ResourceProvider

    fun init(context: Context) {
        val appDb = AppDataBase.localDataBase(context)
        val priceDbItemToDataMapper = SavedTripPriceDbToDataMapper.BaseSavedTripPriceDbToDataMapper()
        val priceDbDataToDbMapper = BaseSavedTripPriceDataToDbMapper()
        val priceRepository = PriceRepositoryImpl(appDb, priceDbDataToDbMapper, priceDbItemToDataMapper)
        val inputDomainMapper = BasePriceInputDomainToDataMapper()
        val resultDomainMapper = BasePriceResultDataToDomainMapper()
        val priceDbDomainToDataMapper = BaseSavedTripPriceDomainToDataMapper()
        val priceDataToDomainMapper = BasePriceDbItemDataToDomainMapper()
        resourceProvider = ResourceProvider.Base(context)
        interactor = PriceInteractor.Base(priceRepository, inputDomainMapper, resultDomainMapper, priceDbDomainToDataMapper, priceDataToDomainMapper)
    }
}