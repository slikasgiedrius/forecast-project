package com.giedrius.forecastproject.forecast.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.forecast.network.Forecast
import kotlinx.android.synthetic.main.item_forecast.view.label1
import kotlinx.android.synthetic.main.item_forecast.view.label2

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: Forecast) {
        itemView.label1.text = forecast.country
        itemView.label2.text = forecast.distance
    }
}
