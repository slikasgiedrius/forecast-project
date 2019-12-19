package com.giedrius.forecastproject.weekly.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.giedrius.forecastproject.R

class WeeklyViewHolderFactory {

    fun create(parent: ViewGroup): WeeklyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_forecast, parent, false)
        return WeeklyViewHolder(view)
    }
}