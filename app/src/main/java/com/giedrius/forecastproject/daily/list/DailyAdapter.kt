package com.giedrius.forecastproject.daily.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.daily.network.DailyForecasts

class DailyAdapter(
    private val factory: DailyViewHolderFactory
) : RecyclerView.Adapter<DailyViewHolder>() {

    private val dailyForecasts = mutableListOf<DailyForecasts>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount() = dailyForecasts.size

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.bind(dailyForecasts[position])
    }

    fun setAll(forecasts: List<DailyForecasts>) {
        this.dailyForecasts.clear()
        this.dailyForecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}