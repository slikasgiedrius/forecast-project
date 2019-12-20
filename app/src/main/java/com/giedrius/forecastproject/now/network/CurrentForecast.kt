package com.giedrius.forecastproject.now.network

import com.google.gson.annotations.SerializedName

data class CurrentForecast(
    @SerializedName("LocalObservationDateTime") val localObservationDateTime: String,
    @SerializedName("EpochTime") val epochTime: Int,
    @SerializedName("WeatherText") val weatherText: String,
    @SerializedName("WeatherIcon") val weatherIcon: Int,
    @SerializedName("HasPrecipitation") val hasPrecipitation: Boolean,
    @SerializedName("PrecipitationType") val precipitationType: String,
    @SerializedName("IsDayTime") val isDayTime: Boolean,
    @SerializedName("Temperature") val temperature: Temperature,
    @SerializedName("MobileLink") val mobileLink: String,
    @SerializedName("Link") val link: String
)

data class Temperature(
    @SerializedName("Metric") val metric: Metric,
    @SerializedName("Imperial") val imperial: Imperial
)

data class Imperial(
    @SerializedName("Value") val value: Int,
    @SerializedName("Unit") val unit: String,
    @SerializedName("UnitType") val unitType: Int
)

data class Metric(
    @SerializedName("Value") val value: Double,
    @SerializedName("Unit") val unit: String,
    @SerializedName("UnitType") val unitType: Int
)