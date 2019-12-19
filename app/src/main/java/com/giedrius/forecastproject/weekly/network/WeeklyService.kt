package com.giedrius.forecastproject.weekly.network

import com.giedrius.forecastproject.hourly.network.Hourly
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeeklyService {

    @GET("forecasts/v1/daily/5day/{locationKey}")
    fun getWeeklyForecast(@Path("locationKey") locationKey: String, @Query("apikey") apiKey: String): Single<Weekly>
}

