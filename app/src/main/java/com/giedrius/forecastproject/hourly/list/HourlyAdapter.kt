package com.giedrius.forecastproject.hourly.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.hourly.network.Hourly

class HourlyAdapter (
    private val factory: HourlyViewHolderFactory
) : RecyclerView.Adapter<HourlyViewHolder>() {

    private val hourlyForecasts = mutableListOf<Hourly>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount() = hourlyForecasts.size

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(hourlyForecasts[position])
    }

    fun setAll(forecasts: List<Hourly>) {
        this.hourlyForecasts.clear()
        this.hourlyForecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}