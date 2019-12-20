package com.giedrius.forecastproject.daily.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.daily.network.DailyForecasts
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusString
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusTemp
import com.giedrius.forecastproject.utils.extensions.formateDateToMonthsAndDays
import com.giedrius.forecastproject.utils.extensions.resIdByName
import kotlinx.android.synthetic.main.item_daily_forecast.view.iw_conditions
import kotlinx.android.synthetic.main.item_daily_forecast.view.tv_conditions_description
import kotlinx.android.synthetic.main.item_daily_forecast.view.tv_temperature
import kotlinx.android.synthetic.main.item_daily_forecast.view.tv_time

class DailyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: DailyForecasts) {
        val image: Int = itemView.context.resIdByName("ic_${forecast.day.icon}")
        itemView.iw_conditions.setBackgroundResource(image)
        itemView.tv_time.text = formateDateToMonthsAndDays(forecast.date)
        itemView.tv_conditions_description.text = forecast.day.iconPhrase
        itemView.tv_temperature.text = "${fahrenheitToCelciusTemp(forecast.temperature.minimum.value)}" +
                " ${fahrenheitToCelciusString()}" + " / " +
                "${fahrenheitToCelciusTemp(forecast.temperature.maximum.value)}" +
                " ${fahrenheitToCelciusString()}"
    }
}
