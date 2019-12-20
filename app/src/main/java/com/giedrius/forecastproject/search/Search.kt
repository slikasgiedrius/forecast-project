package com.giedrius.forecastproject.search

import com.google.gson.annotations.SerializedName

data class Search (
    @SerializedName("Version") val version : Int,
    @SerializedName("Key") val Key : Int,
    @SerializedName("Type") val type : String,
    @SerializedName("Rank") val rank : Int,
    @SerializedName("LocalizedName") val localizedName : String,
    @SerializedName("EnglishName") val englishName : String,
    @SerializedName("PrimaryPostalCode") val primaryPostalCode : String,
    @SerializedName("Region") val region : Region,
    @SerializedName("Country") val country : Country,
    @SerializedName("AdministrativeArea") val administrativeArea : AdministrativeArea,
    @SerializedName("TimeZone") val timeZone : TimeZone,
    @SerializedName("GeoPosition") val geoPosition : GeoPosition,
    @SerializedName("IsAlias") val isAlias : Boolean,
    @SerializedName("SupplementalAdminAreas") val supplementalAdminAreas : List<SupplementalAdminAreas>,
    @SerializedName("DataSets") val dataSets : List<String>
)

data class TimeZone (
    @SerializedName("Code") val code : String,
    @SerializedName("Name") val name : String,
    @SerializedName("GmtOffset") val gmtOffset : Any,
    @SerializedName("IsDaylightSaving") val isDaylightSaving : Boolean,
    @SerializedName("NextOffsetChange") val nextOffsetChange : String
)

data class Region (
    @SerializedName("ID") val iD : String,
    @SerializedName("LocalizedName") val localizedName : String,
    @SerializedName("EnglishName") val englishName : String
)

data class Metric (
    @SerializedName("Value") val value : Int,
    @SerializedName("Unit") val unit : String,
    @SerializedName("UnitType") val unitType : Int
)

data class Imperial (
    @SerializedName("Value") val value : Int,
    @SerializedName("Unit") val unit : String,
    @SerializedName("UnitType") val unitType : Int
)

data class GeoPosition (
    @SerializedName("Latitude") val latitude : Double,
    @SerializedName("Longitude") val longitude : Double,
    @SerializedName("Elevation") val elevation : Elevation
)

data class Elevation (
    @SerializedName("Metric") val metric : Metric,
    @SerializedName("Imperial") val imperial : Imperial
)

data class Country (
    @SerializedName("ID") val iD : String,
    @SerializedName("LocalizedName") val localizedName : String,
    @SerializedName("EnglishName") val englishName : String
)

data class AdministrativeArea (
    @SerializedName("ID") val iD : String,
    @SerializedName("LocalizedName") val localizedName : String,
    @SerializedName("EnglishName") val englishName : String,
    @SerializedName("Level") val level : Int,
    @SerializedName("LocalizedType") val localizedType : String,
    @SerializedName("EnglishType") val englishType : String,
    @SerializedName("CountryID") val countryID : String
)

data class SupplementalAdminAreas (
    @SerializedName("Level") val level : Int,
    @SerializedName("LocalizedName") val localizedName : String,
    @SerializedName("EnglishName") val englishName : String
)