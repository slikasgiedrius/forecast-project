package com.giedrius.forecastproject.hourly.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HourlyService {
    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    fun getHourlyForecast(@Path("locationKey") locationKey: String, @Query("apikey") apiKey: String): Single<List<Hourly>>
}