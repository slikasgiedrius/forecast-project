package com.giedrius.forecastproject.hourly.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.hourly.network.Hourly
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusString
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusTemp
import com.giedrius.forecastproject.utils.extensions.formateDateToHoursAndMinutes
import kotlinx.android.synthetic.main.item_hourly_forecast.view.label1
import kotlinx.android.synthetic.main.item_hourly_forecast.view.label2

class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: Hourly) {
        itemView.label1.text = formateDateToHoursAndMinutes(forecast.dateTime)
        itemView.label2.text = "${fahrenheitToCelciusTemp(forecast.temperature.value)} ${fahrenheitToCelciusString()}"
    }
}
