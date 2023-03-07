package edu.quinnipiac.ser210.firstapp

data class Weather(
    val city_name: String,
    val country_code: String,
    val `data`: List<Data>,
    val lat: Double,
    val lon: Double,
    val state_code: String,
    val timezone: String
)