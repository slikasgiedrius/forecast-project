package com.giedrius.forecastproject.utils.database

interface LocationStorage {
    fun saveLocation(locationKey: String)
    fun getLocation(): String
    fun removeLocation()
}
