package com.perry.API
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException;
import java.util.concurrent.TimeUnit


object LightRGBRepo {
    var client = OkHttpClient()
    var request = GetWrapper(client)
    val gson = GsonBuilder().create()


    fun get(): LightRGB {
        val url = "http://worldclockapi.com/api/json/est/now"
        val data = LightRGB(0,0,0)
        request.GET(url, object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val respData = response.body()?.string()
                println("Request made sucessfully!")
                println(respData)
                val jsonObject = gson.fromJson(respData,TimeObject::class.java)
                println(jsonObject.currentDateTime.subSequence(11,16))
            }

            override fun onFailure(call: Call, e: IOException) {
                println("REQUEST FAILED!")
            }
        })
        return data
    }


}

class TimeObject(val id: String,
                 val currentDateTime: String,
                 val utcOffset: String,
                 val isDayLightSavingsTime: Boolean,
                 val dayOfTheWeek: String,
                 val timeSoneName: String,
                 val currentFileTime: Long,
                 val ordinalDate: String)