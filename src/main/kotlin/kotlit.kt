package com.perry

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

fun main() {
    val url = "https://jsonplaceholder.typicode.com/users"
    val request = Request.Builder()
        .url(url)
        .build()
    val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .build()
    val jsonResp = client.newCall(request).enqueue(object: Callback {
        override fun onResponse(call: Call, response: Response) {
            val body = response.body()?.string()
            val gson = GsonBuilder().create()
            val json: List<TestRest> = gson.fromJson(body, Array<TestRest>::class.java).toList()
            for (jsonObject in json){
                println(jsonObject.name)
                println(jsonObject.username)
                println(jsonObject.address.geo.lat)
                println(jsonObject.address.geo.lng)
                println()
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    })
}

class TestRest(val id: Int,
               val name: String,
               val username: String,
               val email: String,
               val address: TestRestAddress,
               val phone: String,
               val website: String,
               val company: TestRestCompany)

class TestRestAddress(val street: String,
                      val suite: String,
                      val city: String,
                      val zipcode: String,
                      val geo: TestRestAddressGeo)

class TestRestAddressGeo(val lat: String,
                         val lng: String)

class TestRestCompany(val name: String,
                      val catchPhrase: String,
                      val bs: String)