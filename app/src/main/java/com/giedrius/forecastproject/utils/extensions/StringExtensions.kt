package com.giedrius.forecastproject.utils.extensions

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun fahrenheitToCelciusString(): String {
    return "C";
}

fun formateDateToHoursAndMinutes(dateToBeFormatted: Date): String {
    val df = SimpleDateFormat("HH:mm:ss")
    val date: Date = dateToBeFormatted
    val cal = Calendar.getInstance()
    cal.time = date
    val output = df.format(date)
    return output
}

fun formateDateToMonthsAndDays(dateToBeFormatted: Date): String {
    val df = SimpleDateFormat("MM-dd")
    val date: Date = dateToBeFormatted
    val cal = Calendar.getInstance()
    cal.time = date
    val output = df.format(date)
    return output
}
