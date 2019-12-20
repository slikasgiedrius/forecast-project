package com.giedrius.forecastproject.hourly.network

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Hourly(
    @SerializedName("DateTime") val dateTime : Date,
    @SerializedName("EpochDateTime") val epochDateTime : Int,
    @SerializedName("WeatherIcon") val weatherIcon : Int,
    @SerializedName("IconPhrase") val iconPhrase : String,
    @SerializedName("HasPrecipitation") val hasPrecipitation : Boolean,
    @SerializedName("IsDaylight") val isDaylight : Boolean,
    @SerializedName("Temperature") val temperature : Temperature,
    @SerializedName("PrecipitationProbability") val precipitationProbability : Int,
    @SerializedName("MobileLink") val mobileLink : String,
    @SerializedName("Link") val link : String
)

data class Temperature (
    @SerializedName("Value") val value : Int,
    @SerializedName("Unit") val unit : String,
    @SerializedName("UnitType") val unitType : Int
)