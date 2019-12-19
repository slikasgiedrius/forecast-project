package com.giedrius.forecastproject.weekly.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.weekly.network.DailyForecasts
import com.giedrius.forecastproject.weekly.network.Weekly
import kotlinx.android.synthetic.main.item_forecast.view.label1
import kotlinx.android.synthetic.main.item_forecast.view.label2

class WeeklyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: DailyForecasts) {
        itemView.label1.text = forecast.date
        itemView.label2.text = "${forecast.temperature.minimum.value} - ${forecast.temperature.maximum.value} F"
    }
}
