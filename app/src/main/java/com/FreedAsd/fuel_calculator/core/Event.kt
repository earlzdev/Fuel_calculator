package com.FreedAsd.fuel_calculator.core

class Event<T>(private val data: T) {

    private var handled = false

    val value: T? get() {
        if (handled) return null
        return data
    }
}