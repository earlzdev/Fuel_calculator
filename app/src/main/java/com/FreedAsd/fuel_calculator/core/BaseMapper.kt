package com.freedasd.fuel_calculator.core

interface BaseMapper<T, V> {

    fun map(data: T): V
}