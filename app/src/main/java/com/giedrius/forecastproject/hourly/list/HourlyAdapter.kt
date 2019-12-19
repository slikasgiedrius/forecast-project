package com.giedrius.forecastproject.hourly.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.hourly.network.Hourly

class HourlyAdapter (
    private val factory: HourlyViewHolderFactory
) : RecyclerView.Adapter<HourlyViewHolder>() {

    private val forecasts = mutableListOf<Hourly>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount() = forecasts.size

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(forecasts[position])
    }

    fun setAll(forecasts: List<Hourly>) {
        this.forecasts.clear()
        this.forecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}