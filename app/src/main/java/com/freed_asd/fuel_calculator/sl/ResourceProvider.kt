package com.freed_asd.fuel_calculator.sl

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun string(@StringRes resId: Int): String

    fun string(@StringRes resId: Int, vararg args: Any): String

    class Base(private val context: Context): ResourceProvider {

        override fun string(resId: Int) = context.getString(resId)

        override fun string(resId: Int, vararg args: Any) = context.getString(resId, *args)
    }
}