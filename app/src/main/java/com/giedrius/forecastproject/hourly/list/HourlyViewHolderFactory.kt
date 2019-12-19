package com.giedrius.forecastproject.hourly.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.giedrius.forecastproject.R

class HourlyViewHolderFactory {

    fun create(parent: ViewGroup): HourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_forecast, parent, false)
        return HourlyViewHolder(view)
    }
}