package com.giedrius.forecastproject.now.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NowService {
    @GET("currentconditions/v1/{locationKey}")
    fun getCurrentForecast(@Path("locationKey") locationKey: String, @Query("apikey") apiKey: String): Single<List<CurrentForecast>>
}