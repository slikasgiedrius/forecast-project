package com.giedrius.forecastproject.hourly.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.hourly.network.Hourly
import kotlinx.android.synthetic.main.item_forecast.view.label1
import kotlinx.android.synthetic.main.item_forecast.view.label2

class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: Hourly) {
//        itemView.label1.text = forecast.country
//        itemView.label2.text = forecast.distance
    }
}
