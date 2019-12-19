package com.giedrius.forecastproject.daily.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.daily.network.DailyForecasts
import kotlinx.android.synthetic.main.item_daily_forecast.view.label1
import kotlinx.android.synthetic.main.item_daily_forecast.view.label2

class DailyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: DailyForecasts) {
        itemView.label1.text = forecast.date
        itemView.label2.text = "${forecast.temperature.minimum.value} - ${forecast.temperature.maximum.value} F"
    }
}
