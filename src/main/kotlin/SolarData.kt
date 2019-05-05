package com.perry

import com.perry.services.ApiService
import java.awt.Color
import java.time.LocalDateTime

data class SolarData (val sunrise: LocalDateTime, val sunset: LocalDateTime)


class SolarDataModule {
    init {
        //setDates()
    }


    companion object {

        fun beginFetching() {
            while(true) {
                val solarData = ApiService.getSolarData()
                determineColor(solarData)
                // rgbService.setColor(rgba);

                Thread.sleep(1000)
            }
        }

        private fun determineColor(solarData: SolarData): Color {
            val defaultOffset = 6
            val today = LocalDateTime.now()
            val currentHourAsDecimal = today.hour + (today.minute/60) + (solarData.sunset.hour - defaultOffset)
            val lightness = (if (currentHourAsDecimal <= 11) currentHourAsDecimal / 11 else (23-today.hour) / 11)

            return Color(0, 128, 255, (lightness/1)*255)
        }
    }


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