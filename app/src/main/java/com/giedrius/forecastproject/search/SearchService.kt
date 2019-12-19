package com.giedrius.forecastproject.search

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("locations/v1/cities/search")
    fun getSearchResults(@Query("apikey") apiKey: String, @Query("q") query: String): Single<List<Search>>
}