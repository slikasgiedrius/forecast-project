package com.giedrius.forecastproject.utils.extensions

fun fahrenheitToCelciusTemp(fahrenheit: Int): Int {
    return ((fahrenheit - 32) * 5 / 9);
}