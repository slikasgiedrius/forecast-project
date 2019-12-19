package com.giedrius.forecastproject.weekly.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.weekly.network.Weekly
import kotlinx.android.synthetic.main.item_forecast.view.label1
import kotlinx.android.synthetic.main.item_forecast.view.label2

class WeeklyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(forecast: Weekly) {
//        itemView.label1.text = forecast.country
//        itemView.label2.text = forecast.distance
    }
}
