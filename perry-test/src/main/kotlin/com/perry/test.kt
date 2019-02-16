package com.perry

import khttp.get

fun main() {
    val user = User("Caleb")
    println("yo waddup ${user.name}, heres your data:")
    val resp = get("https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400&date=today").jsonObject
    println(resp)

}

class User(val name: String)