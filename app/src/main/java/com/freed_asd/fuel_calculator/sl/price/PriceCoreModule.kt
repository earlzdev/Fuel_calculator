package com.freed_asd.fuel_calculator.sl.price

import android.content.Context
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.price.BasePriceItemDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.PriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbToDataItemMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.sl.ResourceProvider

class PriceCoreModule {

    lateinit var interactor: PriceInteractor
    lateinit var resourceProvider: ResourceProvider


    fun init(context: Context) {
        val appDb = AppDataBase.localDataBase(context)
        val priceDbItemToDataMapper = BasePriceDbToDataItemMapper()
        val priceDbDataToDbMapper = BasePriceItemDbMapper()
        val priceRepository = PriceRepositoryImpl(appDb, priceDbDataToDbMapper, priceDbItemToDataMapper)
        val inputDomainMapper = BasePriceInputDomainToDataMapper()
        val resultDomainMapper = BasePriceResultDataToDomainMapper()
        val priceDbDomainToDataMapper = BasePriceDbITemDomainMapper()
        val priceDataToDomainMapper = BasePriceDbItemDataToDomainMapper()
        resourceProvider = ResourceProvider.Base(context)
        interactor = PriceInteractor.Base(priceRepository, inputDomainMapper, resultDomainMapper, priceDbDomainToDataMapper, priceDataToDomainMapper)
    }
}