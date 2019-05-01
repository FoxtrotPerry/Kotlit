package com.perry

import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

class SolarData {
    init {
        //setDates()
    }

    var sunrise: LocalDateTime = LocalDateTime.now()

    var sunset: LocalDateTime = LocalDateTime.now()

/*    fun setDates() {
        val response = queryAPI().getJSONObject("results")

        val sunsetDate = response.get("sunset").toString()
        val sunriseDate = response.get("sunrise").toString()

        this.sunrise = convertStringToDate(sunriseDate)
        this.sunset = convertStringToDate(sunsetDate)
    }
*/
/*    private fun convertStringToDate(date: String) : LocalDateTime {
        var (hours, minutes, seconds) = date.substring(0, date.indexOf(" ")).split(":")

        val amPmValue = date.substring(date.indexOf(" ")+1, date.length)
        if (amPmValue == "PM") hours += 12

        val timestamp = LocalDateTime.atStartOfDay().plusHours(hours.toLong()).plusMinutes(minutes.toLong()).plusSeconds(seconds.toLong())
        return timestamp
    }*/

    // private fun queryAPI() = get("https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400&date=today").jsonObject
}