package com.giedrius.forecastproject.forecast.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.forecast.network.Forecast

class ForecastAdapter(
        private val factory: ForecastViewHolderFactory
) : RecyclerView.Adapter<ForecastViewHolder>() {

    private val forecasts = mutableListOf<Forecast>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount() = forecasts.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecasts[position])
    }

    fun setAll(forecasts: List<Forecast>) {
        this.forecasts.clear()
        this.forecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}
