package com.giedrius.forecastproject.daily.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DailyService {

    @GET("forecasts/v1/daily/5day/{locationKey}")
    fun getDailyForecast(@Path("locationKey") locationKey: String, @Query("apikey") apiKey: String): Single<Daily>
}

