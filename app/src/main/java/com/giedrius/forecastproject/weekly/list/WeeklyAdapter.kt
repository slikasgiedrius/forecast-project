package com.giedrius.forecastproject.weekly.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.weekly.network.Weekly

class WeeklyAdapter (
    private val factory: WeeklyViewHolderFactory
) : RecyclerView.Adapter<WeeklyViewHolder>() {

    private val forecasts = mutableListOf<Weekly>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount() = forecasts.size

    override fun onBindViewHolder(holder: WeeklyViewHolder, position: Int) {
        holder.bind(forecasts[position])
    }

    fun setAll(forecasts: List<Weekly>) {
        this.forecasts.clear()
        this.forecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}