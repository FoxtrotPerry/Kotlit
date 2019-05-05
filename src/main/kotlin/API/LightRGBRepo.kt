package com.perry.API
import okhttp3.Callback
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.concurrent.TimeUnit


object LightRGBRepo {
//    fun get() =


}

fun GET(url: String, callback: Callback) {
    var client = OkHttpClient.Builder()
        .connectTimeout(5,TimeUnit.SECONDS)
        .writeTimeout(5,TimeUnit.SECONDS)
        .readTimeout(5,TimeUnit.SECONDS)
        .build()


}