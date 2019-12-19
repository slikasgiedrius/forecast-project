package com.giedrius.forecastproject.utils.database

interface LocationStorage {
    fun saveLocation(location: String)
    fun getLocation(): String
    fun removeLocation()
}
