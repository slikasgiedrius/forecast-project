package com.giedrius.forecastproject.hourly.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.hourly.network.Hourly
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusString
import com.giedrius.forecastproject.utils.extensions.fahrenheitToCelciusTemp
import com.giedrius.forecastproject.utils.extensions.formateDateToHoursAndMinutes
import com.giedrius.forecastproject.utils.extensions.resIdByName
import kotlinx.android.synthetic.main.item_hourly_forecast.view.iw_conditions
import kotlinx.android.synthetic.main.item_hourly_forecast.view.tv_conditions_description
import kotlinx.android.synthetic.main.item_hourly_forecast.view.tv_temperature
import kotlinx.android.synthetic.main.item_hourly_forecast.view.tv_time

class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: Hourly) {
        val image: Int = itemView.context.resIdByName("ic_${forecast.weatherIcon}")
        itemView.iw_conditions.setBackgroundResource(image)
        itemView.tv_time.text = formateDateToHoursAndMinutes(forecast.dateTime)
        itemView.tv_conditions_description.text = forecast.iconPhrase
        itemView.tv_temperature.text = "${fahrenheitToCelciusTemp(forecast.temperature.value)} ${fahrenheitToCelciusString()}"
    }
}
