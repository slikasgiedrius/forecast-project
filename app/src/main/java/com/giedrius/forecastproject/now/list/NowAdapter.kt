package com.giedrius.forecastproject.now.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.now.network.Now

class NowAdapter (
    private val factory: NowViewHolderFactory
    ) : RecyclerView.Adapter<NowViewHolder>() {

        private val forecasts = mutableListOf<Now>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowViewHolder {
            return factory.create(parent)
        }

        override fun getItemCount() = forecasts.size

        override fun onBindViewHolder(holder: NowViewHolder, position: Int) {
            holder.bind(forecasts[position])
        }

        fun setAll(forecasts: List<Now>) {
            this.forecasts.clear()
            this.forecasts.addAll(forecasts)
            notifyDataSetChanged()
        }
    }