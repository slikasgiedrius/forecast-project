package com.giedrius.forecastproject.forecast.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.giedrius.forecastproject.R

class ForecastViewHolderFactory {

    fun create(parent: ViewGroup): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_forecast, parent, false)
        return ForecastViewHolder(view)
    }
}
