package com.giedrius.forecastproject.database

interface LocationStorage {
    fun saveLocation(location: String)
    fun getLocation(): String
    fun removeLocation()
}
