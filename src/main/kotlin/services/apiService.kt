package com.perry.services

import com.google.gson.GsonBuilder
import com.perry.API.GetWrapper
import com.perry.API.LightRGB
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class ApiService {
    companion object {
        fun loadAndPrintRGB() {
            val client = OkHttpClient()
            val request = GetWrapper(client)
            val gson = GsonBuilder().create()
            val url = "http://localhost:3232/API"

            var RGB: LightRGB
            request.GET(url, object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    val respData = response.body()?.string()
                    RGB = gson.fromJson(respData, LightRGB::class.java)
                    println(RGB.formatColor())
                }

                override fun onFailure(call: Call, e: IOException) {
                    println("Failed to load $url")
                }
            })
        }
    }
}
