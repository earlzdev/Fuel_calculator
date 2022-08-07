package com.freed_asd.fuel_calculator.core

interface BaseMapper<T, V> {

    fun map(data: T): V
}