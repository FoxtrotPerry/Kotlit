package com.perry.API
import com.google.gson.GsonBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.*
import java.io.IOException;
import java.util.concurrent.TimeUnit


object LightRGBRepo {
    var client = OkHttpClient()
    var request = GetWrapper(client)
    val gson = GsonBuilder().create()

    fun get(): LightRGB {
        val url = "http://worldclockapi.com/api/json/est/now"
        var data = LightRGB(0, 0, 0, time = "")
        GlobalScope.async {
            val getJob = GlobalScope.async {
                request.GET(url, object : Callback {
                    override fun onResponse(call: Call, response: Response) {
                        val respData = response.body()?.string()
                        println("Request made sucessfully!")
                        println(respData)
                        val jsonObject = gson.fromJson(respData, TimeObject::class.java)
                        val percentThroughDay =
                            (jsonObject.currentDateTime.subSequence(11,13).toString().toFloat()/24) +
                            (jsonObject.currentDateTime.subSequence(14,16).toString().toFloat()/60/24)
                        println("Percent through day is: ${percentThroughDay}")
                        data.time = jsonObject.currentDateTime.subSequence(11, 16).toString()
                    }

                    override fun onFailure(call: Call, e: IOException) {
                        println("REQUEST FAILED!")
                    }
                })
            }
        }
        while (data.time==""){
            Thread.sleep(20L)
        }
        println("object time is: ${data.time}")
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