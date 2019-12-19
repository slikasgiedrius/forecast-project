package com.giedrius.forecastproject.daily.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.giedrius.forecastproject.R

class DailyViewHolderFactory {

    fun create(parent: ViewGroup): DailyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_daily_forecast, parent, false)
        return DailyViewHolder(view)
    }
}