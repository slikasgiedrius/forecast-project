package com.giedrius.forecastproject.daily.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.daily.network.DailyForecasts
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusString
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusTemp
import com.giedrius.forecastproject.utils.extensions.formateDateToMonthsAndDays
import kotlinx.android.synthetic.main.item_daily_forecast.view.label1
import kotlinx.android.synthetic.main.item_daily_forecast.view.label2

class DailyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: DailyForecasts) {
        itemView.label1.text = formateDateToMonthsAndDays(forecast.date)
        itemView.label2.text = "${fahrenheitToCelciusTemp(forecast.temperature.minimum.value)}" +
                " ${fahrenheitToCelciusString()}" + "/" +
                "${fahrenheitToCelciusTemp(forecast.temperature.maximum.value)}" +
                " ${fahrenheitToCelciusString()}"
    }
}
