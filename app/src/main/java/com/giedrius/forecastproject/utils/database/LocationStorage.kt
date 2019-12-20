package com.giedrius.forecastproject.utils.database

interface LocationStorage {
    fun saveLocationKey(locationKey: String)
    fun getLocationKey(): String

    fun saveLocationName(locationName: String)
    fun getLocationName(): String
    fun removeLocation()
}
