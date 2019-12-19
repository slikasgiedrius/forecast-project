package com.giedrius.forecastproject.repository

interface LocationStorage {

    fun saveLocation(location: String)

    fun getLocation(): String

    fun removeLocation()
}
